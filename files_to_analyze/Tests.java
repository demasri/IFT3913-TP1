package com.gym.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.gym.src.DatabaseMembre;
import com.gym.src.DatabaseProfessionnel;
import com.gym.src.DatabaseServices;
import com.gym.src.Professionnel;

/**
 * La classe "TestGenID" s'occupe des tests unitaires relatifs
 * aux identifiants assignés aux membres, professionnels et services
 * du Centre.
 * @author william
 *
 */
class TestGenID {
	
	/**
	 * Instances de classes utilisées pour les tests.
	 */
	Professionnel testPro1;
	Professionnel testPro2;
	
	/**
	 * Cette méthode met en place l'environnement de test.
	 */
	@Before
	public void setUp() {
		
		//Identifiants de 2 membres aléatoires et leur longueur.
		String IdMembre1 = DatabaseMembre.genID();
		String IdMembre2 = DatabaseMembre.genID();
		int lengthIDMembre1 = IdMembre1.length();
		int lengthIDMembre2 = IdMembre2.length();
		
	
		testPro1 = new Professionnel("John", "Doe", "Street", "City", "State", "AAA 123", IdProfessionnel1);
		testPro2 = new Professionnel("Jane", "Doe", "Street", "City", "State", "BBB 456", IdProfessionnel2);
		//Identifiants de 2 professionnels aléatoires, leur longeur et leurs 2 derniers chiffres.
		String IdProfessionnel1 = DatabaseProfessionnel.genID();
		String IdProfessionnel2 = DatabaseProfessionnel.genID();
		int lengthIDProfessionnel1 = IdProfessionnel1.length();
		int lengthIDProfessionnel2 = IdProfessionnel2.length();
		String IdProfessionnel1derniers = IdProfessionnel1.substring(7, 9);
		String IdProfessionnel2derniers = IdProfessionnel2.substring(7, 9);
		
		//Identifiants de 4 services, ainsi que leurs 3 premiers et 2 derniers chiffres.
		String type1 = "Tennis";
		String type2 = "Natation";
		String IdService1 = DatabaseServices.genID(testPro1, type1);
		String IdService1premiers = IdService1.substring(0,3);
		String IdService1derniers = IdService1.substring(5,7);
		String IdService2 = DatabaseServices.genID(testPro1, type2);
		String IdService2premiers = IdService2.substring(0,3);
		String IdService2derniers = IdService2.substring(5,7);
		String IdService3 = DatabaseServices.genID(testPro2, type1);
		String IdService3premiers = IdService3.substring(0,3);
		String IdService3derniers = IdService3.substring(5,7);
		String IdService4 = DatabaseServices.genID(testPro2, type2);
		String IdService4premiers = IdService4.substring(0,3);
		String IdService4derniers = IdService4.substring(5,7);
	}

	/**
	 * Cette méthode s'occupe de générer tous les tests unitaires.
	 */
	@Test
	void test() {
		
		//vérifier que les identifiants de 2 membres sont différents, et composés
		//de 9 chiffres.
		assertEquals(lengthIDMembre1, 9);
		assertEquals(lengthIDMembre2, 9);
		assertNotEquals(IdMembre1,IdMembre2);;
		
		//vérifier que les identifiants des professionnels sont à 9 chiffres.
		assertEquals(lengthIDProfessionnel1, 9);
		assertEquals(lengthIDProfessionnel2, 9);

		//vérifier que les identifiants des services sont à 7 chiffres.
		assertEquals(IdService1.length(), 7);
		assertEquals(IdService2.length(), 7);
		assertEquals(IdService3.length(), 7);
		assertEquals(IdService4.length(), 7);
		
		//vérifier que les 2 derniers chiffres de l'identifiant d'un service
		//sont égaux aux 2 derniers chiffres de l'identifiant du professionnel
		//proposant ce service.
		assertEquals(IdProfessionnel1derniers, IdService1derniers);
		assertEquals(IdProfessionnel1derniers, IdService2derniers);
		assertEquals(IdProfessionnel2derniers, IdService3derniers);
		assertEquals(IdProfessionnel2derniers, IdService4derniers);
		
		//vérifier que les identifiants de 2 services sont différents.
	    assertNotEquals(IdService1, IdService2);
	    assertNotEquals(IdService3, IdService4);
	    
	    //vérifier que les 3 premiers chiffres des identifiants de 2 mêmes services
	    //sont égaux.
	    assertEquals(IdService1premiers, IdService3premiers);
	    assertEquals(IdService2premiers, IdService4premiers);
		
	}

}