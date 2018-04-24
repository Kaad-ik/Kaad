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
		saveIngredientType();
		saveFood();
		savePlayer();
	}
	
	public void saveIngredientType() {
		iT.setPricePerGramms(200);
		iT.setTypeName("marhalábszár");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT);

		iT1.setPricePerGramms(30);
		iT1.setTypeName("vöröshagyma");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT1);
		
		iT2.setPricePerGramms(100);
		iT2.setTypeName("csirkemell");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT2);

		iT3.setPricePerGramms(90);
		iT3.setTypeName("disznózsír");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT3);

		iT4.setPricePerGramms(200);
		iT4.setTypeName("fűszerpaprika");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT4);

		iT5.setPricePerGramms(85);
		iT5.setTypeName("paradicsom");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT5);

		iT6.setPricePerGramms(50);
		iT6.setTypeName("erős paprika");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT6);

		iT7.setPricePerGramms(30);
		iT7.setTypeName("csípős paprikakrém");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT7);

		iT8.setPricePerGramms(90);
		iT8.setTypeName("só");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT8);

		iT9.setPricePerGramms(200);
		iT9.setTypeName("sárgarépa");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT9);

		iT10.setPricePerGramms(85);
		iT10.setTypeName("fehérrépa");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT10);

		iT11.setPricePerGramms(50);
		iT11.setTypeName("burgonya");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT11);

		iT12.setPricePerGramms(30);
		iT12.setTypeName("víz");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT12);

		iT13.setPricePerGramms(90);
		iT13.setTypeName("tojás");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT13);

		iT14.setPricePerGramms(200);
		iT14.setTypeName("finomliszt");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT14);

		iT15.setPricePerGramms(85);
		iT15.setTypeName("darált sertéshús");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT15);

		iT16.setPricePerGramms(50);
		iT16.setTypeName("olaj");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT16);

		iT17.setPricePerGramms(200);
		iT17.setTypeName("passzírozott paradicsom");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT17);

		iT18.setPricePerGramms(85);
		iT18.setTypeName("ketchup");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT18);

		iT19.setPricePerGramms(50);
		iT19.setTypeName("oregánó");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT19);

		iT20.setPricePerGramms(30);
		iT20.setTypeName("kakukkfű");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT20);

		iT21.setPricePerGramms(90);
		iT21.setTypeName("bazsalikom");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT21);

		iT22.setPricePerGramms(200);
		iT22.setTypeName("fekete bors");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT22);

		iT32.setPricePerGramms(85);
		iT32.setTypeName("tészta");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT32);

		iT23.setPricePerGramms(50);
		iT23.setTypeName("fokhagyma");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT23);

		iT24.setPricePerGramms(50);
		iT24.setTypeName("kristálycukor");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT24);

		iT25.setPricePerGramms(30);
		iT25.setTypeName("paprika");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT25);

		iT26.setPricePerGramms(90);
		iT26.setTypeName("csirke alsócomb");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT26);

		iT27.setPricePerGramms(200);
		iT27.setTypeName("tejföl");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT27);

		iT28.setPricePerGramms(85);
		iT28.setTypeName("majoranna");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT28);

		iT29.setPricePerGramms(50);
		iT29.setTypeName("tej");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT29);

		iT30.setPricePerGramms(50);
		iT30.setTypeName("édesburgonya");
		iT.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT30);

		iT31.setPricePerGramms(30);
		iT31.setTypeName("szerecsendió");
		iT.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT31);
	}
	
	private void saveFood(){
		
		Food food = new Food();
		food.setName("Gulyásleves");
		food.addIngredient(saveIngredient(iT,  1, IngredientUnitType.DB)); //TODO: hozzávalók hozzáadása a kajákhoz
		food.addIngredient(saveIngredient(iT,  2, IngredientUnitType.DB));
		food.setRecipe("A zöldségeket felvágjuk. A zöldségeket és a marhapörköltet egy lábasban feltesszük főni, és hozzáadjuk a vizet. Elkészítjük a csipetkét: a tojást kissé felverjük, hozzáadunk egy csipet sót, és annyi liszttel keverjük el, hogy keményebb tészta állagot kapjunk. A tésztát gombócba gyúrjuk, és amikor a zöldség megfőtt, akkor a forrásban lévő levesbe csipkedjük. A tészta 5-8 perc alatt fő meg.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/gulyasleves_0.jpg");
		foodRepository.save(food);
		
		food = new Food();
		food.setName("Palacsinta");
		food.setRecipe("A hozzávalókat összekeverjük alaposan, majd egy serpenyőben kevés olajon kisütjük.");
		food.setImgUrl("http://www.mindmegette.hu/images/155/O/crop_201606241617_palacsinta.jpg");
		foodRepository.save(food);

		food = new Food();
		food.setName("Paprikás csirke");
		food.setRecipe("A vöröshagymát, fokhagymát, paprikát, paradicsomot kevés olajon megforgatjuk. Hozzáadjuk a csirkecombokat, kicsit még együtt pároljuk, fűszerezzük. Fedő alatt kb. 30 percig főzzük, majd hozzáadjuk a tejfölt.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/paprikas-csirke-nokedlivel.jpg");
		foodRepository.save(food);
		
		food = new Food();
		food.setName("Nokedli");
		food.setRecipe("A liszthez adjuk a tojást és a vizet, összedolgozzuk, és lobogó vízben galuskaszaggató segítségével kifőzzük a nokedlit.");
		food.setImgUrl("https://img-global.cpcdn.com/016_recipes/0c16004dd2d7c6ec/751x532cq70/photo.jpg");
		foodRepository.save(food);

		food = new Food();
		food.setName("Fűszeres édesburgonyachips");
		food.setRecipe("Az édesburgonyákat meghámozzuk, és közel egyenlő méretű cikkekre vágjuk. Tiszta nejlonzacskóba tesszük, meglocsoljuk olívaolajjal, beleszórjuk a fűszereket. A zacskó nyakát befogva jól összerázzuk az egészet, hogy mindehol érje a burgonyacikkeket a finom olaj és a fűszerek. Sütőpapírral bélelt tepsibe borítjuk és 180 fokra előmelegített sütőben kb. 20-25 perc alatt megsütjük.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/fuszeres_edesburgonyachips.jpg");
		foodRepository.save(food);

		food = new Food();
		food.setName("Bolognai spagetti");
		food.setRecipe("A hagymát apróra vágjuk, majd az olajon megpároljuk. Hozzáadjuk a darált húst, és együtt pároljuk tovább. Sózzuk, borsozzuk. 5 perc után beletesszük a passzírozott paradicsomot és a ketchupot is (a ketchup elhagyható, én azért szoktam beletenni, hogy kicsit édesebb legyen). Pár perc után felöntjük 1 dl vízzel, és lefedve 5 percig főzzük. Beleszórjuk a bazsalikomot, oregánót és a kakukkfüvet. A kifőtt tésztára szedjük, reszelt sajttal megszórjuk.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/187932_178284_bolognai1.jpg");
		foodRepository.save(food);
		
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
		Optional<Food> food = foodRepository.findByName("Bolognai spagetti");
		user.addCooked(food.get());
		food = foodRepository.findByName("Palacsinta");
		user.addCooked(food.get());
		food = foodRepository.findByName("Paprikás csirke");
		user.addCooked(food.get());
		food = foodRepository.findByName("Nokedli");
		user.addCooked(food.get());
		food = foodRepository.findByName("Fűszeres édesburgonyachips");
		user.addCooked(food.get());
		user.addIngredient(saveIngredient(iT1, 1, IngredientUnitType.DB)); //TODO: hozzávalók hozzáadása a userekhez
		userRepository.save(user);

		user = new User();
		user.setUserName("Harriet");
		user.setPassword("asdfgh");
		user.setEmail("harri@recipe.hu");
		user.setCurrency(Currency.USD);
		user.setMoney(200);
		user.setFullName("Harriet Sanders");
		user.setRole(Role.USER);
		food = foodRepository.findByName("Bolognai spagetti");
		user.addCooked(food.get());
		userRepository.save(user);

		user = new User();
		user.setUserName("Louis");
		user.setPassword("lulu1234");
		user.setEmail("lulu@recipe.hu");
		user.setCurrency(Currency.EUR);
		user.setMoney(450);
		user.setFullName("Louis Miller");
		user.setRole(Role.USER);
		food = foodRepository.findByName("Nokedli");
		user.addCooked(food.get());
		userRepository.save(user);

		user = new User();
		user.setUserName("Réka");
		user.setPassword("recipeApp01");
		user.setEmail("r200@recipe.hu");
		user.setCurrency(Currency.HUF);
		user.setMoney(8000);
		user.setFullName("Horváth Réka");
		user.setRole(Role.USER);
		userRepository.save(user);

		user = new User();
		user.setUserName("Keitha");
		user.setPassword("safepsw");
		user.setEmail("keitha@recipe.hu");
		user.setCurrency(Currency.HUF);
		user.setMoney(4500);
		user.setFullName("Keitha Garcia");
		user.setRole(Role.USER);
		food = foodRepository.findByName("Paprikás csirke");
		user.addCooked(food.get());
		food = foodRepository.findByName("Palacsinta");
		user.addCooked(food.get());
		userRepository.save(user);

		user = new User();
		user.setUserName("Nicola");
		user.setPassword("nic1990");
		user.setEmail("nic@recipe.hu");
		user.setCurrency(Currency.USD);
		user.setMoney(1000);
		user.setFullName("Nicola Bailey");
		user.setRole(Role.USER);
		food = foodRepository.findByName("Nokedli");
		user.addCooked(food.get());
		food = foodRepository.findByName("Palacsinta");
		user.addCooked(food.get());
		userRepository.save(user);

		user = new User();
		user.setUserName("Derek");
		user.setPassword("dboyasd");
		user.setEmail("derek@recipe.hu");
		user.setCurrency(Currency.USD);
		user.setMoney(300);
		user.setFullName("Derek Matthews");
		user.setRole(Role.USER);
		food = foodRepository.findByName("Bolognai spagetti");
		user.addCooked(food.get());
		userRepository.save(user);

		user = new User();
		user.setUserName("Jamesina");
		user.setPassword("idkpsw");
		user.setEmail("jami@recipe.hu");
		user.setCurrency(Currency.EUR);
		user.setMoney(150);
		user.setFullName("Jamesina Blaese");
		user.setRole(Role.GUEST);
		food = foodRepository.findByName("Palacsinta");
		user.addCooked(food.get());
		userRepository.save(user);

		user = new User();
		user.setUserName("Tammy");
		user.setPassword("ymmat");
		user.setEmail("tammy@recipe.hu");
		user.setCurrency(Currency.EUR);
		user.setMoney(70);
		user.setFullName("Tammy Watson");
		user.setRole(Role.GUEST);
		userRepository.save(user);

		user = new User();
		user.setUserName("Nick");
		user.setPassword("nickname");
		user.setEmail("nick@recipe.hu");
		user.setCurrency(Currency.EUR);
		user.setMoney(70);
		user.setFullName("Nick Anderson");
		user.setRole(Role.GUEST);
		food = foodRepository.findByName("Fűszeres édesburgonyachips");
		user.addCooked(food.get());
		userRepository.save(user);
	}
	
	private Ingredient saveIngredient(IngredientType ingredientType, int quantity, IngredientUnitType unitType){
		Ingredient ing = new Ingredient();
		ing.setType(ingredientType);
		ing.setQuantity(quantity);
		ing.setUnit(unitType);
		ingredientRepository.save(ing);
		return ing;
	} 
}
