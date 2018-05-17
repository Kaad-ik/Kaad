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

// TODO: Auto-generated Javadoc
/**
 * The Class PopulateDatabaseService.
 */
@Service
@Transactional
public class PopulateDatabaseService {

	/** The user repository. */
	@Autowired private UserRepository userRepository;
	
	/** The food repository. */
	@Autowired private FoodRepository foodRepository;
	
	/** The ingredient type repository. */
	@Autowired private IngredientTypeRepository ingredientTypeRepository;
	
	/** The ingredient repository. */
	@Autowired private IngredientRepository ingredientRepository;

	/** The i T. */
	private IngredientType iT = new IngredientType();
	
	/** The i T 1. */
	private IngredientType iT1 = new IngredientType();
	
	/** The i T 2. */
	private IngredientType iT2 = new IngredientType();
	
	/** The i T 3. */
	private IngredientType iT3 = new IngredientType();
	
	/** The i T 4. */
	private IngredientType iT4 = new IngredientType();
	
	/** The i T 5. */
	private IngredientType iT5 = new IngredientType();
	
	/** The i T 6. */
	private IngredientType iT6 = new IngredientType();
	
	/** The i T 7. */
	private IngredientType iT7 = new IngredientType();
	
	/** The i T 8. */
	private IngredientType iT8 = new IngredientType();
	
	/** The i T 9. */
	private IngredientType iT9 = new IngredientType();
	
	/** The i T 10. */
	private IngredientType iT10 = new IngredientType();
	
	/** The i T 11. */
	private IngredientType iT11 = new IngredientType();
	
	/** The i T 12. */
	private IngredientType iT12 = new IngredientType();
	
	/** The i T 13. */
	private IngredientType iT13 = new IngredientType();
	
	/** The i T 14. */
	private IngredientType iT14 = new IngredientType();
	
	/** The i T 15. */
	private IngredientType iT15 = new IngredientType();
	
	/** The i T 16. */
	private IngredientType iT16 = new IngredientType();
	
	/** The i T 17. */
	private IngredientType iT17 = new IngredientType();
	
	/** The i T 18. */
	private IngredientType iT18 = new IngredientType();
	
	/** The i T 19. */
	private IngredientType iT19 = new IngredientType();
	
	/** The i T 20. */
	private IngredientType iT20 = new IngredientType();
	
	/** The i T 21. */
	private IngredientType iT21 = new IngredientType();
	
	/** The i T 22. */
	private IngredientType iT22 = new IngredientType();
	
	/** The i T 23. */
	private IngredientType iT23 = new IngredientType();
	
	/** The i T 24. */
	private IngredientType iT24 = new IngredientType();
	
	/** The i T 25. */
	private IngredientType iT25 = new IngredientType();
	
	/** The i T 26. */
	private IngredientType iT26 = new IngredientType();
	
	/** The i T 27. */
	private IngredientType iT27 = new IngredientType();
	
	/** The i T 28. */
	private IngredientType iT28 = new IngredientType();
	
	/** The i T 29. */
	private IngredientType iT29 = new IngredientType();
	
	/** The i T 30. */
	private IngredientType iT30 = new IngredientType();
	
	/** The i T 31. */
	private IngredientType iT31 = new IngredientType();
	
	/** The i T 32. */
	private IngredientType iT32 = new IngredientType();

	/**
	 * Populate database.
	 */
	public void populateDatabase() {
		saveIngredientType();
		saveFood();
		savePlayer();
	}
	
	/**
	 * Save ingredient type.
	 */
	public void saveIngredientType() {
		iT.setPricePerGramms(200);
		iT.setTypeName("marhalábszár");
		iT.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT);

		iT1.setPricePerGramms(30);
		iT1.setTypeName("vöröshagyma");
		iT1.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT1);
		
		iT2.setPricePerGramms(100);
		iT2.setTypeName("csirkemell");
		iT2.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT2);

		iT3.setPricePerGramms(90);
		iT3.setTypeName("disznózsír");
		iT3.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT3);

		iT4.setPricePerGramms(200);
		iT4.setTypeName("fűszerpaprika");
		iT4.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT4);

		iT5.setPricePerGramms(85);
		iT5.setTypeName("paradicsom");
		iT5.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT5);

		iT6.setPricePerGramms(50);
		iT6.setTypeName("erős paprika");
		iT6.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT6);

		iT7.setPricePerGramms(30);
		iT7.setTypeName("csípős paprikakrém");
		iT7.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT7);

		iT8.setPricePerGramms(90);
		iT8.setTypeName("só");
		iT8.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT8);

		iT9.setPricePerGramms(200);
		iT9.setTypeName("sárgarépa");
		iT9.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT9);

		iT10.setPricePerGramms(85);
		iT10.setTypeName("fehérrépa");
		iT10.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT10);

		iT11.setPricePerGramms(50);
		iT11.setTypeName("burgonya");
		iT11.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT11);

		iT12.setPricePerGramms(30);
		iT12.setTypeName("víz");
		iT12.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT12);

		iT13.setPricePerGramms(90);
		iT13.setTypeName("tojás");
		iT13.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT13);

		iT14.setPricePerGramms(200);
		iT14.setTypeName("finomliszt");
		iT14.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT14);

		iT15.setPricePerGramms(85);
		iT15.setTypeName("darált sertéshús");
		iT15.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT15);

		iT16.setPricePerGramms(50);
		iT16.setTypeName("olaj");
		iT16.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT16);

		iT17.setPricePerGramms(200);
		iT17.setTypeName("passzírozott paradicsom");
		iT17.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT17);

		iT18.setPricePerGramms(85);
		iT18.setTypeName("ketchup");
		iT18.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT18);

		iT19.setPricePerGramms(50);
		iT19.setTypeName("oregánó");
		iT19.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT19);

		iT20.setPricePerGramms(30);
		iT20.setTypeName("kakukkfű");
		iT20.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT20);

		iT21.setPricePerGramms(90);
		iT21.setTypeName("bazsalikom");
		iT21.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT21);

		iT22.setPricePerGramms(200);
		iT22.setTypeName("fekete bors");
		iT22.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT22);

		iT32.setPricePerGramms(85);
		iT32.setTypeName("tészta");
		iT32.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT32);

		iT23.setPricePerGramms(50);
		iT23.setTypeName("fokhagyma");
		iT23.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT23);

		iT24.setPricePerGramms(50);
		iT24.setTypeName("kristálycukor");
		iT24.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT24);

		iT25.setPricePerGramms(30);
		iT25.setTypeName("paprika");
		iT25.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT25);

		iT26.setPricePerGramms(90);
		iT26.setTypeName("csirke alsócomb");
		iT26.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT26);

		iT27.setPricePerGramms(200);
		iT27.setTypeName("tejföl");
		iT27.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT27);

		iT28.setPricePerGramms(85);
		iT28.setTypeName("majoranna");
		iT28.setCurrency(Currency.EUR);
		ingredientTypeRepository.save(iT28);

		iT29.setPricePerGramms(50);
		iT29.setTypeName("tej");
		iT29.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT29);

		iT30.setPricePerGramms(50);
		iT30.setTypeName("édesburgonya");
		iT30.setCurrency(Currency.USD);
		ingredientTypeRepository.save(iT30);

		iT31.setPricePerGramms(30);
		iT31.setTypeName("szerecsendió");
		iT31.setCurrency(Currency.HUF);
		ingredientTypeRepository.save(iT31);
	}
	
	/**
	 * Save food.
	 */
	private void saveFood(){
		
		Food food = new Food();
		food.setName("Gulyásleves");
		food.addIngredient(saveIngredient(iT,  1, IngredientUnitType.DB)); //TODO: hozzávalók hozzáadása a kajákhoz
		food.addIngredient(saveIngredient(iT1,  40, IngredientUnitType.DKG));
		food.addIngredient(saveIngredient(iT3,  10, IngredientUnitType.DKG));
		food.addIngredient(saveIngredient(iT4,  1, IngredientUnitType.EK));
		food.addIngredient(saveIngredient(iT5,  1, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT6,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT7,  1, IngredientUnitType.KK));
		food.addIngredient(saveIngredient(iT8,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT9,  3, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT10,  3, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT11,  2, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT12,  2, IngredientUnitType.L));
		food.setRecipe("A zöldségeket felvágjuk. A zöldségeket és a marhapörköltet egy lábasban feltesszük főni, és hozzáadjuk a vizet. Elkészítjük a csipetkét: a tojást kissé felverjük, hozzáadunk egy csipet sót, és annyi liszttel keverjük el, hogy keményebb tészta állagot kapjunk. A tésztát gombócba gyúrjuk, és amikor a zöldség megfőtt, akkor a forrásban lévő levesbe csipkedjük. A tészta 5-8 perc alatt fő meg.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/gulyasleves_0.jpg");
		foodRepository.save(food);
		
		food = new Food();
		food.setName("Palacsinta");
		food.addIngredient(saveIngredient(iT14,  12, IngredientUnitType.DKG));
		food.addIngredient(saveIngredient(iT24,  2, IngredientUnitType.TK));
		food.addIngredient(saveIngredient(iT13,  2, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT29,  3, IngredientUnitType.DL));
		food.addIngredient(saveIngredient(iT16,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT8,  1, IngredientUnitType.EGY_KEVES));
		food.setRecipe("A hozzávalókat összekeverjük alaposan, majd egy serpenyőben kevés olajon kisütjük.");
		food.setImgUrl("http://www.mindmegette.hu/images/155/O/crop_201606241617_palacsinta.jpg");
		foodRepository.save(food);

		food = new Food();
		food.setName("Paprikás csirke");
		food.addIngredient(saveIngredient(iT16, 1, IngredientUnitType.DL));
		food.addIngredient(saveIngredient(iT1,  2, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT23,  1, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT8,  1, IngredientUnitType.KK));
		food.addIngredient(saveIngredient(iT22, 2, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT4,  1, IngredientUnitType.TK));
		food.addIngredient(saveIngredient(iT19,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT25, 1, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT5,  1, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT26,  6, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT27,  1, IngredientUnitType.EK));
		food.addIngredient(saveIngredient(iT28,  1, IngredientUnitType.KK));
		food.setRecipe("A vöröshagymát, fokhagymát, paprikát, paradicsomot kevés olajon megforgatjuk. Hozzáadjuk a csirkecombokat, kicsit még együtt pároljuk, fűszerezzük. Fedő alatt kb. 30 percig főzzük, majd hozzáadjuk a tejfölt.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/paprikas-csirke-nokedlivel.jpg");
		foodRepository.save(food);
		
		food = new Food();
		food.setName("Nokedli");
		food.addIngredient(saveIngredient(iT14,  50, IngredientUnitType.DKG));
		food.addIngredient(saveIngredient(iT13,  1, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT12,  5, IngredientUnitType.DL));
		food.setRecipe("A liszthez adjuk a tojást és a vizet, összedolgozzuk, és lobogó vízben galuskaszaggató segítségével kifőzzük a nokedlit.");
		food.setImgUrl("https://img-global.cpcdn.com/016_recipes/0c16004dd2d7c6ec/751x532cq70/photo.jpg");
		foodRepository.save(food);

		food = new Food();
		food.setName("Fűszeres édesburgonyachips");
		food.addIngredient(saveIngredient(iT30,  2, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT16,  3, IngredientUnitType.EK));
		food.addIngredient(saveIngredient(iT8,  2, IngredientUnitType.CSIPET));
		food.addIngredient(saveIngredient(iT22,  1, IngredientUnitType.KK));
		food.addIngredient(saveIngredient(iT31,  1, IngredientUnitType.EGY_KEVES));
		food.setRecipe("Az édesburgonyákat meghámozzuk, és közel egyenlő méretű cikkekre vágjuk. Tiszta nejlonzacskóba tesszük, meglocsoljuk olívaolajjal, beleszórjuk a fűszereket. A zacskó nyakát befogva jól összerázzuk az egészet, hogy mindehol érje a burgonyacikkeket a finom olaj és a fűszerek. Sütőpapírral bélelt tepsibe borítjuk és 180 fokra előmelegített sütőben kb. 20-25 perc alatt megsütjük.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/fuszeres_edesburgonyachips.jpg");
		foodRepository.save(food);

		food = new Food();
		food.setName("Bolognai spagetti");
		food.addIngredient(saveIngredient(iT1, 1, IngredientUnitType.DB));
		food.addIngredient(saveIngredient(iT15,  1, IngredientUnitType.KG));
		food.addIngredient(saveIngredient(iT16,  3, IngredientUnitType.EK));
		food.addIngredient(saveIngredient(iT8,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT17, 2, IngredientUnitType.DL));
		food.addIngredient(saveIngredient(iT18,  10, IngredientUnitType.ML));
		food.addIngredient(saveIngredient(iT19,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT20, 1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT21,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT22,  1, IngredientUnitType.EGY_KEVES));
		food.addIngredient(saveIngredient(iT12,  1, IngredientUnitType.DL));
		food.addIngredient(saveIngredient(iT32,  50, IngredientUnitType.DKG));
		food.setRecipe("A hagymát apróra vágjuk, majd az olajon megpároljuk. Hozzáadjuk a darált húst, és együtt pároljuk tovább. Sózzuk, borsozzuk. 5 perc után beletesszük a passzírozott paradicsomot és a ketchupot is (a ketchup elhagyható, én azért szoktam beletenni, hogy kicsit édesebb legyen). Pár perc után felöntjük 1 dl vízzel, és lefedve 5 percig főzzük. Beleszórjuk a bazsalikomot, oregánót és a kakukkfüvet. A kifőtt tésztára szedjük, reszelt sajttal megszórjuk.");
		food.setImgUrl("http://www.nosalty.hu/files/imagecache/recept/recept_kepek/187932_178284_bolognai1.jpg");
		foodRepository.save(food);
		
	}  

	/**
	 * Save player.
	 */
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
		user.addIngredient(saveIngredient(iT18,  30, IngredientUnitType.ML));
		user.addIngredient(saveIngredient(iT30,  1, IngredientUnitType.DB));
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
		user.addIngredient(saveIngredient(iT30,  1, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT13,  10, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT14, 30, IngredientUnitType.DKG));
		user.addIngredient(saveIngredient(iT24,  14, IngredientUnitType.DKG));
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
		user.addIngredient(saveIngredient(iT25, 4, IngredientUnitType.DB));
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
		user.addIngredient(saveIngredient(iT8,  1, IngredientUnitType.KG));
		user.addIngredient(saveIngredient(iT25, 4, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT19,  1, IngredientUnitType.EGY_KEVES));
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
		user.addIngredient(saveIngredient(iT13,  8, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT29,  2, IngredientUnitType.L));
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
		user.addIngredient(saveIngredient(iT25, 1, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT5,  2, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT13,  4, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT29,  1, IngredientUnitType.L));
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
		user.addIngredient(saveIngredient(iT9,  5, IngredientUnitType.DB));
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
		user.addIngredient(saveIngredient(iT9,  2, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT5,  2, IngredientUnitType.DB));
		user.addIngredient(saveIngredient(iT13,  4, IngredientUnitType.DB));
		userRepository.save(user);
	}
	
	/**
	 * Save ingredient.
	 *
	 * @param ingredientType the ingredient type
	 * @param quantity the quantity
	 * @param unitType the unit type
	 * @return the ingredient
	 */
	private Ingredient saveIngredient(IngredientType ingredientType, int quantity, IngredientUnitType unitType){
		Ingredient ing = new Ingredient();
		ing.setType(ingredientType);
		ing.setQuantity(quantity);
		ing.setUnit(unitType);
		ingredientRepository.save(ing);
		return ing;
	} 
}
