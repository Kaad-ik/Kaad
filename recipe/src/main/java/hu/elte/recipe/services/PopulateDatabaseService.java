package hu.elte.recipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.repositories.UserRepository;


import hu.elte.recipe.entities.Food;
import hu.elte.recipe.repositories.FoodRepository; 

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.repositories.IngredientRepository; 
import hu.elte.recipe.entities.IngredientUnitType;

import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.repositories.IngredientTypeRepository;

@Service
@Transactional
public class PopulateDatabaseService {
	
	@Autowired private UserRepository userRepository;
	@Autowired private FoodRepository foodRepository;
	@Autowired private IngredientTypeRepository ingredientTypeRepository;
	@Autowired private IngredientRepository ingredientRepository;

	private User user = new User();
	private User user1 = new User();
	private User user2 = new User();
	private User user3 = new User();
	private User user4 = new User();
	private User user5 = new User();
	private User user6 = new User();
	private User user7 = new User();
	private User user8 = new User();
	private User user9 = new User();

	private IngredientType iT = new IngredientType();
	private IngredientType iT1 = new IngredientType();
	private IngredientType iT2 = new IngredientType();
	private IngredientType iT3 = new IngredientType();
	private IngredientType iT4 = new IngredientType();
	private IngredientType iT5 = new IngredientType();
	private IngredientType iT6 = new IngredientType();
	private IngredientType iT7 = new IngredientType();
	private IngredientType iT8 = new IngredientType();
	private IngredientType iT9 = new IngredientType();
	private IngredientType iT10 = new IngredientType();
	private IngredientType iT11 = new IngredientType();
	private IngredientType iT12 = new IngredientType();
	private IngredientType iT13 = new IngredientType();
	private IngredientType iT14 = new IngredientType();
	private IngredientType iT15 = new IngredientType();
	private IngredientType iT16 = new IngredientType();
	private IngredientType iT17 = new IngredientType();
	private IngredientType iT18 = new IngredientType();
	private IngredientType iT19 = new IngredientType();
	private IngredientType iT20 = new IngredientType();
	private IngredientType iT21 = new IngredientType();
	private IngredientType iT22 = new IngredientType();
	private IngredientType iT23 = new IngredientType();
	private IngredientType iT24 = new IngredientType();
	private IngredientType iT25 = new IngredientType();
	private IngredientType iT26 = new IngredientType();
	private IngredientType iT27 = new IngredientType();
	private IngredientType iT28 = new IngredientType();
	private IngredientType iT29 = new IngredientType();
	private IngredientType iT30 = new IngredientType();
	private IngredientType iT31 = new IngredientType();
	private IngredientType iT32 = new IngredientType();

	public void populateDatabase() {
		saveFood();
		saveIngredient();
		savePlayer();
	}

	private void savePlayer() {
		
		user.setUserName("admin");
		user.setPassword("admin");
		user.setEmail("admin@admin.hu");
		user.setCurrency(Currency.HUF);
		user.setMoney(3000);
		user.setFullName("Admin Admin");
		user.setRole(Role.ADMIN);
		Optional<Food> f1 = foodRepository.findByName("Gulyásleves");
		user.addCooked(f1.get());
		userRepository.save(user);

		user1.setUserName("Harriet");
		user1.setPassword("asdfgh");
		user1.setEmail("harri@recipe.hu");
		user1.setCurrency(Currency.USD);
		user1.setMoney(200);
		user1.setFullName("Harriet Sanders");
		user1.setRole(Role.USER);
		Optional<Food> f2 = foodRepository.findByName("Gulyásleves");
		user1.addCooked(f2.get());
		Optional<Food> f3 = foodRepository.findByName("Palacsinta");
		user1.addCooked(f3.get());
		userRepository.save(user1);

		user2.setUserName("Louis");
		user2.setPassword("lulu1234");
		user2.setEmail("lulu@recipe.hu");
		user2.setCurrency(Currency.EUR);
		user2.setMoney(450);
		user2.setFullName("Louis Miller");
		user2.setRole(Role.USER);
		Optional<Food> f4 = foodRepository.findByName("Nokedli");
		user2.addCooked(f4.get());
		userRepository.save(user2);

		user3.setUserName("Réka");
		user3.setPassword("recipeApp01");
		user3.setEmail("r200@recipe.hu");
		user3.setCurrency(Currency.HUF);
		user3.setMoney(8000);
		user3.setFullName("Horváth Réka");
		user3.setRole(Role.USER);
		userRepository.save(user3);

		user4.setUserName("Keitha");
		user4.setPassword("safepsw");
		user4.setEmail("keitha@recipe.hu");
		user4.setCurrency(Currency.HUF);
		user4.setMoney(4500);
		user4.setFullName("Keitha Garcia");
		user4.setRole(Role.USER);
		Optional<Food> f5 = foodRepository.findByName("Palacsinta");
		user4.addCooked(f5.get());
		userRepository.save(user4);

		user5.setUserName("Nicola");
		user5.setPassword("nic1990");
		user5.setEmail("nic@recipe.hu");
		user5.setCurrency(Currency.USD);
		user5.setMoney(1000);
		user5.setFullName("Nicola Bailey");
		user5.setRole(Role.USER);
		Optional<Food> f6 = foodRepository.findByName("Fűszeres édesburgonyachips");
		user5.addCooked(f6.get());
		Optional<Food> f7 = foodRepository.findByName("Bolognai spagetti");
		user5.addCooked(f7.get());
		userRepository.save(user5);

		user6.setUserName("Derek");
		user6.setPassword("dboyasd");
		user6.setEmail("derek@recipe.hu");
		user6.setCurrency(Currency.USD);
		user6.setMoney(300);
		user6.setFullName("Derek Matthews");
		user6.setRole(Role.USER);
		Optional<Food> f8 = foodRepository.findByName("Bolognai spagetti");
		user6.addCooked(f8.get());
		userRepository.save(user6);

		user7.setUserName("Jamesina");
		user7.setPassword("idkpsw");
		user7.setEmail("jami@recipe.hu");
		user7.setCurrency(Currency.EUR);
		user7.setMoney(150);
		user7.setFullName("Jamesina Blaese");
		user7.setRole(Role.GUEST);
		Optional<Food> f9 = foodRepository.findByName("Fűszeres édesburgonyachips");
		user7.addCooked(f9.get());
		Optional<Food> f11 = foodRepository.findByName("Gulyásleves");
		user7.addCooked(f11.get());
		userRepository.save(user7);

		user8.setUserName("Tammy");
		user8.setPassword("ymmat");
		user8.setEmail("tammy@recipe.hu");
		user8.setCurrency(Currency.EUR);
		user8.setMoney(70);
		user8.setFullName("Tammy Watson");
		user8.setRole(Role.GUEST);
		userRepository.save(user8);

		user9.setUserName("Nick");
		user9.setPassword("nickname");
		user9.setEmail("nick@recipe.hu");
		user9.setCurrency(Currency.EUR);
		user9.setMoney(70);
		user9.setFullName("Nick Anderson");
		user9.setRole(Role.GUEST);
		Optional<Food> f10 = foodRepository.findByName("Palacsinta");
		user9.addCooked(f10.get());
		userRepository.save(user9);
	}
	
	private void saveFood(){

		iT.setPricePergrams(200);
		iT.setTypename("marhalábszár");
		ingredientTypeRepository.save(iT);

		iT1.setPricePergrams(30);
		iT1.setTypename("vöröshagyma");
		ingredientTypeRepository.save(iT1);

		iT3.setPricePergrams(90);
		iT3.setTypename("disznózsír");
		ingredientTypeRepository.save(iT3);

		iT4.setPricePergrams(200);
		iT4.setTypename("fűszerpaprika");
		ingredientTypeRepository.save(iT4);

		iT5.setPricePergrams(85);
		iT5.setTypename("paradicsom");
		ingredientTypeRepository.save(iT5);

		iT6.setPricePergrams(50);
		iT6.setTypename("erős paprika");
		ingredientTypeRepository.save(iT6);

		iT7.setPricePergrams(30);
		iT7.setTypename("csípős paprikakrém");
		ingredientTypeRepository.save(iT7);

		iT8.setPricePergrams(90);
		iT8.setTypename("só");
		ingredientTypeRepository.save(iT8);

		iT9.setPricePergrams(200);
		iT9.setTypename("sárgarépa");
		ingredientTypeRepository.save(iT9);

		iT10.setPricePergrams(85);
		iT10.setTypename("fehérrépa");
		ingredientTypeRepository.save(iT10);

		iT11.setPricePergrams(50);
		iT11.setTypename("burgonya");
		ingredientTypeRepository.save(iT11);

		iT12.setPricePergrams(30);
		iT12.setTypename("víz");
		ingredientTypeRepository.save(iT12);

		iT13.setPricePergrams(90);
		iT13.setTypename("tojás");
		ingredientTypeRepository.save(iT13);

		iT14.setPricePergrams(200);
		iT14.setTypename("finomliszt");
		ingredientTypeRepository.save(iT14);

		iT15.setPricePergrams(85);
		iT15.setTypename("darált sertéshús");
		ingredientTypeRepository.save(iT15);

		iT16.setPricePergrams(50);
		iT16.setTypename("olaj");
		ingredientTypeRepository.save(iT16);

		iT17.setPricePergrams(200);
		iT17.setTypename("passzírozott paradicsom");
		ingredientTypeRepository.save(iT17);

		iT18.setPricePergrams(85);
		iT18.setTypename("ketchup");
		ingredientTypeRepository.save(iT18);

		iT19.setPricePergrams(50);
		iT19.setTypename("oregánó");
		ingredientTypeRepository.save(iT19);

		iT20.setPricePergrams(30);
		iT20.setTypename("kakukkfű");
		ingredientTypeRepository.save(iT20);

		iT21.setPricePergrams(90);
		iT21.setTypename("bazsalikom");
		ingredientTypeRepository.save(iT21);

		iT22.setPricePergrams(200);
		iT22.setTypename("fekete bors");
		ingredientTypeRepository.save(iT22);

		iT32.setPricePergrams(85);
		iT32.setTypename("tészta");
		ingredientTypeRepository.save(iT32);

		iT23.setPricePergrams(50);
		iT23.setTypename("fokhagyma");
		ingredientTypeRepository.save(iT23);

		iT24.setPricePergrams(50);
		iT24.setTypename("kristálycukor");
		ingredientTypeRepository.save(iT24);

		iT25.setPricePergrams(30);
		iT25.setTypename("paprika");
		ingredientTypeRepository.save(iT25);

		iT26.setPricePergrams(90);
		iT26.setTypename("csirke alsócomb");
		ingredientTypeRepository.save(iT26);

		iT27.setPricePergrams(200);
		iT27.setTypename("tejföl");
		ingredientTypeRepository.save(iT27);

		iT28.setPricePergrams(85);
		iT28.setTypename("majoranna");
		ingredientTypeRepository.save(iT28);

		iT29.setPricePergrams(50);
		iT29.setTypename("tej");
		ingredientTypeRepository.save(iT29);

		iT30.setPricePergrams(50);
		iT30.setTypename("édesburgonya");
		ingredientTypeRepository.save(iT30);

		iT31.setPricePergrams(30);
		iT31.setTypename("szerecsendió");
		ingredientTypeRepository.save(iT31);

		Food food = new Food();
		food.setName("Gulyásleves");
		//food.addIngredient(iT);
		food.setRecipe("A zöldségeket felvágjuk. A zöldségeket és a marhapörköltet egy lábasban feltesszük főni, és hozzáadjuk a vizet. Elkészítjük a csipetkét: a tojást kissé felverjük, hozzáadunk egy csipet sót, és annyi liszttel keverjük el, hogy keményebb tészta állagot kapjunk. A tésztát gombócba gyúrjuk, és amikor a zöldség megfőtt, akkor a forrásban lévő levesbe csipkedjük. A tészta 5-8 perc alatt fő meg.");
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
	
	private void saveIngredient(){
		Ingredient ing = new Ingredient();
		ing.setOwner(user);
		ing.setType(iT);
		ing.setQuantity(1);
		ing.setUnit(IngredientUnitType.KG);
		ingredientRepository.save(ing);
	} 
}
