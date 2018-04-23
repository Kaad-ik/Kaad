package hu.elte.recipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.repositories.UserRepository;

/*
import hu.elte.recipe.entities.Food;
import hu.elte.recipe.repositories.FoodRepository;

import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.repositories.IngredientTypeRepository;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.repositories.IngredientRepository; */

@Service
@Transactional
public class PopulateDatabaseService {
	
	@Autowired private UserRepository userRepository;
	//@Autowired private FoodRepository foodRepository;
	//@Autowired private IngredientTypeRepository ingredientTypeRepository;
	//@Autowired private IngredientRepository ingredientRepository;
	
	public void populateDatabase() {
		savePlayer();
		//saveFood();
		//saveType();
		//saveIngredient();
	}

	private void savePlayer() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");
		user.setEmail("admin@admin.hu");
		user.setCurrency(Currency.HUF);
		user.setMoney(3000);
		user.setFullName("Admin Admin");
		user.setRole(Role.ADMIN);
		userRepository.save(user);

		User user1 = new User();
		user1.setUserName("Harriet");
		user1.setPassword("asdfgh");
		user1.setEmail("harri@recipe.hu");
		user1.setCurrency(Currency.USD);
		user1.setMoney(200);
		user1.setFullName("Harriet Sanders");
		user1.setRole(Role.USER);
		userRepository.save(user1);

		User user2 = new User();
		user2.setUserName("Louis");
		user2.setPassword("lulu1234");
		user2.setEmail("lulu@recipe.hu");
		user2.setCurrency(Currency.EUR);
		user2.setMoney(450);
		user2.setFullName("Louis Miller");
		user2.setRole(Role.USER);
		userRepository.save(user2);

		User user3 = new User();
		user3.setUserName("Réka");
		user3.setPassword("recipeApp01");
		user3.setEmail("r200@recipe.hu");
		user3.setCurrency(Currency.HUF);
		user3.setMoney(8000);
		user3.setFullName("Horváth Réka");
		user3.setRole(Role.USER);
		userRepository.save(user3);

		User user4 = new User();
		user4.setUserName("Keitha");
		user4.setPassword("safepsw");
		user4.setEmail("keitha@recipe.hu");
		user4.setCurrency(Currency.HUF);
		user4.setMoney(4500);
		user4.setFullName("Keitha Garcia");
		user4.setRole(Role.USER);
		userRepository.save(user4);

		User user5 = new User();
		user5.setUserName("Nicola");
		user5.setPassword("nic1990");
		user5.setEmail("nic@recipe.hu");
		user5.setCurrency(Currency.USD);
		user5.setMoney(1000);
		user5.setFullName("Nicola Bailey");
		user5.setRole(Role.USER);
		userRepository.save(user5);

		User user6 = new User();
		user6.setUserName("Derek");
		user6.setPassword("dboyasd");
		user6.setEmail("derek@recipe.hu");
		user6.setCurrency(Currency.USD);
		user6.setMoney(300);
		user6.setFullName("Derek Matthews");
		user6.setRole(Role.USER);
		userRepository.save(user6);

		User user7 = new User();
		user7.setUserName("Jamesina");
		user7.setPassword("idkpsw");
		user7.setEmail("jami@recipe.hu");
		user7.setCurrency(Currency.EUR);
		user7.setMoney(150);
		user7.setFullName("Jamesina Blaese");
		user7.setRole(Role.GUEST);
		userRepository.save(user7);

		User user8 = new User();
		user8.setUserName("Tammy");
		user8.setPassword("ymmat");
		user8.setEmail("tammy@recipe.hu");
		user8.setCurrency(Currency.EUR);
		user8.setMoney(70);
		user8.setFullName("Tammy Watson");
		user8.setRole(Role.GUEST);
		userRepository.save(user8);

		User user9 = new User();
		user9.setUserName("Nick");
		user9.setPassword("nickname");
		user9.setEmail("nick@recipe.hu");
		user9.setCurrency(Currency.EUR);
		user9.setMoney(70);
		user9.setFullName("Nick Anderson");
		user9.setRole(Role.GUEST);
		userRepository.save(user9);
	}
/*
	private void saveFood(){
		Food food = new Food();
		food.setName("Gulyásleves");
		food.setRecipe("A zöldségeket megtisztítjuk, karikára vágjuk. A feldarabolt zöldségeket és a marhapörköltet egy lábasban feltesszük főni, és hozzáadunk annyi vizet, hogy leves sűrűségű legyen. Elkészítjük a csipetkét: a tojást kissé felverjük, hozzáadunk egy csipet sót, és annyi liszttel keverjük el, hogy keményebb tészta állagot kapjunk. A tésztát gombócba gyúrjuk, és amikor a zöldség megfőtt, akkor a forrásban lévő levesbe csipkedjük. A tészta 5-8 perc alatt fő meg.");
		food.setImgurl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/gulyasleves_0.jpg");
		foodRepository.save(food);

		Food food1 = new Food();
		food1.setName("Palacsinta");
		food1.setRecipe("A hozzávalókat összekeverjük alaposan, majd egy serpenyőben kevés olajon kisütjük.");
		food1.setImgurl("http://www.mindmegette.hu/images/155/O/crop_201606241617_palacsinta.jpg");
		foodRepository.save(food1);

		Food food2 = new Food();
		food2.setName("Paprikás csirke");
		food2.setRecipe("A vöröshagymát, fokhagymát, paprikát, paradicsomot kevés olajon megforgatjuk. Hozzáadjuk a csirkecombokat, kicsit még együtt pároljuk, fűszerezzük. Fedő alatt kb. 30 percig főzzük, majd hozzáadjuk a tejfölt.");
		food2.setImgurl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/paprikas-csirke-nokedlivel.jpg");
		foodRepository.save(food2);

		Food food3 = new Food();
		food3.setName("Nokedli");
		food3.setRecipe("A liszthez adjuk a tojást és a vizet, összedolgozzuk, és lobogó vízben galuskaszaggató segítségével kifőzzük a nokedlit.");
		food3.setImgurl("https://img-global.cpcdn.com/016_recipes/0c16004dd2d7c6ec/751x532cq70/photo.jpg");
		foodRepository.save(food3);

		Food food4 = new Food();
		food4.setName("Fűszeres édesburgonyachips");
		food4.setRecipe("Az édesburgonyákat meghámozzuk, és közel egyenlő méretű cikkekre vágjuk. Tiszta nejlonzacskóba tesszük, meglocsoljuk olívaolajjal, beleszórjuk a fűszereket. A zacskó nyakát befogva jól összerázzuk az egészet, hogy mindehol érje a burgonyacikkeket a finom olaj és a fűszerek. Sütőpapírral bélelt tepsibe borítjuk és 180 fokra előmelegített sütőben kb. 20-25 perc alatt megsütjük.");
		food4.setImgurl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/fuszeres_edesburgonyachips.jpg");
		foodRepository.save(food4);

		Food food5 = new Food();
		food5.setName("Bolognai spagetti");
		food5.setRecipe("A hagymát apróra vágjuk, majd az olajon megpároljuk. Hozzáadjuk a darált húst, és együtt pároljuk tovább. Sózzuk, borsozzuk. 5 perc után beletesszük a passzírozott paradicsomot és a ketchupot is (a ketchup elhagyható, én azért szoktam beletenni, hogy kicsit édesebb legyen). Pár perc után felöntjük 1 dl vízzel, és lefedve 5 percig főzzük. Beleszórjuk a bazsalikomot, oregánót és a kakukkfüvet. A kifőtt tésztára szedjük, reszelt sajttal megszórjuk.");
		food5.setImgurl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/187932_178284_bolognai1.jpg");
		foodRepository.save(food5);

	} 

	private void saveType(){
		IngredientType iT = new IngredientType();
		iT.setPricePergrams(100);
		iT.setTypename("Tejtermék");
		iT.setImgUrl("http://www.netamin.hu/uploads/2014/05/tejtermekek.jpg");
		ingredientTypeRepository.save(iT);

		IngredientType iT1 = new IngredientType();
		iT1.setPricePergrams(130);
		iT1.setTypename("Fűszerek");
		iT1.setImgUrl("http://vir.matusz-vad.hu:2280/webaruhazteszt/images/desc/DESC4224.jpg");
		ingredientTypeRepository.save(iT1);

		IngredientType iT3 = new IngredientType();
		iT3.setPricePergrams(90);
		iT3.setTypename("Zöldségek");
		iT3.setImgUrl("https://cleaneating.hu/wp-content/uploads/2017/02/zoldsegek-es-gyumolcsok-szezonja.jpg");
		ingredientTypeRepository.save(iT3);

		IngredientType iT4 = new IngredientType();
		iT4.setPricePergrams(200);
		iT4.setTypename("Hús");
		iT4.setImgUrl("https://www.dehir.hu/upload/images/wp_cikkek/2013/husok.jpg");
		ingredientTypeRepository.save(iT4);

		IngredientType iT5 = new IngredientType();
		iT5.setPricePergrams(85);
		iT5.setTypename("Tészta");
		iT5.setImgUrl("https://nlc.p3k.hu/uploads/2017/09/teszta.jpg");
		ingredientTypeRepository.save(iT5);

		IngredientType iT6 = new IngredientType();
		iT6.setPricePergrams(50);
		iT6.setTypename("Egyéb");
		iT6.setImgUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSul1-SR7unqeiEoEeTVZIw8asHKOXH1JjScDMlNL9Abl1sroKPtQ");
		ingredientTypeRepository.save(iT6);
	}

	private void saveIngredient(){
		
	} */
}
