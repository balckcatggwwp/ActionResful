package tw.blackcat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.blackcat.model.Animal;

@RestController
public class ReadAnimalController {
	ArrayList<Animal>  animals = new ArrayList<Animal>();
	public  ReadAnimalController() {
		animals.add(new Animal(1,"monkey"));		
		animals.add(new Animal(2,"dog"));
		animals.add(new Animal(3,"cat"));
		animals.add(new Animal(4,"bird"));
		animals.add(new Animal(5,"pig"));//10個
		animals.add(new Animal(6,"tiger"));
		animals.add(new Animal(7,"lion"));
		animals.add(new Animal(8,"elephant"));
		animals.add(new Animal(9,"mouse"));
		animals.add(new Animal(10,"snake"));
	}
	@PostMapping("/animalreader.controller")
	public List<Animal> processReadAnimalAction(@RequestParam("keyword") String animalName){
		return searchResult(animalName);
	}
<<<<<<< HEAD

=======
>>>>>>> test1
	
	private List<Animal> searchResult(String animalName) {
        ArrayList<Animal> result = new ArrayList<Animal>();
        
        for(Animal a: animals) {
        	if(animalName.length()!=0 && a.getAname().contains(animalName)) {
        		result.add(a);
        	}
        }
		return result;
	}
}
