<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Product</title>
    <link rel="stylesheet" href="/mycss/ordersystem.css" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
      var indexPage = 1;
      $(function () {
        load(indexPage);
      });

      function change(page) {
        indexPage = page;
        load(indexPage);
      }

      function load(indexPage) {
        $.ajax({
          type: "post",
          url: "/product/queryByPage/" + indexPage,
          dataType: "json",
          contentType: "application/json",
          success: function (data) {
            $("#showproduct").empty();
            $("#showpage").empty();

            var totalPages = data.totalPages;
            var totalElements = data.totalElements;
            var contnet = data.content;

            console.log("totalPages:" + totalPages);
            console.log("totalElements:" + totalElements);
            console.log(contnet);

            if (data == null) {
              $("table").prepend("<tr><td colspan='2'>暫無資料</td></tr>");
            } else {
              //顯示分頁的產品資訊
              var table = $("#showproduct");
              table.append(
                "<tr id='ptitle'><th>ID</th><th>Product Name</th><th>Product Price</th><th>Date</th><th>Note</th></tr>"
              );
              $.each(contnet, function (i, n) {
                var tr =
                  "<tr align='center'>" +
                  "<td>" +
                  n.id +
                  "</td>" +
                  "<td>" +
                  n.pname +
                  "</td>" +
                  "<td>" +
                  n.price +
                  "</td>" +
                  "<td>" +
                  n.pdate +
                  "</td>" +
                  "<td>" +
                  n.note +
                  "</td>" +
                  "</tr>";
                table.append(tr);
              });

              //顯示分頁資訊(頁數與頁碼)
              var table2 = $("#showpage");
              var tr1 =
                "<tr><td>Total Pages: " +
                data.totalPages +
                " TotalRecords: " +
                data.totalElements +
                "</td>" +
                '<td colspan="3" align="right">Previous ';
              var td = "";
              for (var k = 1; k <= totalPages; k++) {
                td =
                  td +
                  '<button id="myPage" value="' +
                  k +
                  '" onclick="change(' +
                  k +
                  ')">' +
                  k +
                  "</button>&nbsp;";
              }

              var result = tr1 + td + "Next</td></tr>";
              table2.append(result);
            }
          },
        });
      }
    </script>
  </head>
  <body>
    <div id="productListTitle">ProductQuery</div>
    <table id="showproduct" border="1"></table>
    <table id="showpage"></table>
  </body>
</html>
