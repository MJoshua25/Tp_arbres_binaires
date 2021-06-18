package ci.miage.java.tree;

import java.util.Scanner;

import ci.miage.java.tree_util.AbstractImage;
import ci.miage.java.tree_util.Iterator;
import ci.miage.java.tree_util.Node;

/**
 * @author Yao Josué Kouakou
 * @version 5.0
 * @since 2021-06-17
 * 
 *        Classe dÃ©crivant les images en noir et blanc de 256 sur 256 pixels
 *        sous forme d'arbres binaires.
 *
 */

public class Image extends AbstractImage {
	private static final Scanner standardInput = new Scanner(System.in);

	public Image() {
		super();
	}

	public static void closeAll() {
		standardInput.close();
	}

	/**
	 * @param x
	 *            abscisse du point
	 * @param y
	 *            ordonnÃ©e du point
	 * @pre !this.isEmpty()
	 * @return true, si le point (x, y) est allumÃ© dans this, false sinon
	 */
	@Override
	public boolean isPixelOn(int x, int y) {
		Iterator<Node> iterateur = this.iterator();
		var debutX = 0;
		var debutY = 0;
		var fx = 255;
		var fy = 255;
		var aux = 0;

		while(iterateur.getValue().state==2){
			if ((aux % 2) == 0) {
				int miy = (debutY + fy) / 2;
				if (y < miy) {
					iterateur.goLeft();
					fy = miy;
				} else {
					iterateur.goRight();
					debutY = miy+1;
				}
			} else {
				int mix=(debutX +fx)/2;
				if (x<mix){
					iterateur.goLeft();
					fx=mix;
				}else{
					iterateur.goRight();
					debutX =mix+1;
				}
			}
			aux++;
		}

		return iterateur.getValue().state==1;
	}

	/**
	 * this devient identique Ã  image2.
	 *
	 * @param image2
	 *            image Ã  copier
	 *
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void affect(AbstractImage image2) {
		Iterator<Node> iterateur = this.iterator();
		Iterator<Node> iterateur2 = image2.iterator();
		iterateur.clear();
		copyImage(iterateur, iterateur2);
	}

	 public void copyImage(Iterator<Node> iterateur, Iterator<Node> iterateur2) {
		 if (!iterateur2.isEmpty()) {
			 iterateur.addValue(Node.valueOf(iterateur2.getValue().state));
			 iterateur2.goLeft();
			 iterateur.goLeft();
			 copyImage(iterateur, iterateur2);

			 iterateur2.goUp();
			 iterateur.goUp();


			 iterateur2.goRight();
			 iterateur.goRight();
			 copyImage(iterateur, iterateur2);
			 iterateur2.goUp();
			 iterateur.goUp();
		 }
	 }

	/**
	 * this devient rotation de image2 Ã  180 degrÃ©s.
	 *
	 * @param image2
	 *            image pour rotation
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void rotate180(AbstractImage image2) {
		Iterator<Node> iterateur = this.iterator();
		Iterator<Node> iterateur2 = image2.iterator();
		iterateur.clear();
		rotat(iterateur, iterateur2);
	}


	public void rotat(Iterator<Node> iterateur, Iterator<Node> iterateur2) {
		if (!iterateur2.isEmpty()) {
			iterateur.addValue(Node.valueOf(iterateur2.getValue().state));
			iterateur2.goLeft();
			iterateur.goRight();
			rotat(iterateur, iterateur2);

			iterateur2.goUp();
			iterateur.goUp();


			iterateur2.goRight();
			iterateur.goLeft();
			rotat(iterateur, iterateur2);
			iterateur2.goUp();
			iterateur.goUp();
		}
	}


	/**
	 * this devient rotation de image2 Ã  90 degrÃ©s dans le sens des aiguilles
	 * d'une montre.
	 *
	 * @param image2
	 *            image pour rotation
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void rotate90(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction non demeandée");
		System.out.println("-------------------------------------------------");
		System.out.println();	    
	}

	/**
	 * this devient inverse vidÃ©o de this, pixel par pixel.
	 *
	 * @pre !image.isEmpty()
	 */
	@Override
	public void videoInverse() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient image miroir verticale de image2.
	 *
	 * @param image2
	 *            image Ã  agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorV(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient image miroir horizontale de image2.
	 *
	 * @param image2
	 *            image Ã  agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorH(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient quart supÃ©rieur gauche de image2.
	 *
	 * @param image2
	 *            image Ã  agrandir
	 * 
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomIn(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * Le quart supÃ©rieur gauche de this devient image2, le reste de this
	 * devient Ã©teint.
	 * 
	 * @param image2
	 *            image Ã  rÃ©duire
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomOut(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient l'intersection de image1 et image2 au sens des pixels
	 * allumÃ©s.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void intersection(AbstractImage image1, AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient l'union de image1 et image2 au sens des pixels allumÃ©s.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void union(AbstractImage image1, AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * Attention : cette fonction ne doit pas utiliser la commande isPixelOn
	 * 
	 * @return true si tous les points de la forme (x, x) (avec 0 <= x <= 255)
	 *         sont allumÃ©s dans this, false sinon
	 */
	@Override
	public boolean testDiagonal() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	    return false;
	}

	/**
	 * @param x1
	 *            abscisse du premier point
	 * @param y1
	 *            ordonnÃ©e du premier point
	 * @param x2
	 *            abscisse du deuxiÃ¨me point
	 * @param y2
	 *            ordonnÃ©e du deuxiÃ¨me point
	 * @pre !this.isEmpty()
	 * @return true si les deux points (x1, y1) et (x2, y2) sont reprÃ©sentÃ©s par
	 *         la mÃªme feuille de this, false sinon
	 */
	@Override
	public boolean sameLeaf(int x1, int y1, int x2, int y2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}

	/**
	 * @param image2
	 *            autre image
	 * @pre !this.isEmpty() && !image2.isEmpty()
	 * @return true si this est incluse dans image2 au sens des pixels allumÃ©s
	 *         false sinon
	 */
	@Override
	public boolean isIncludedIn(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction à écrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	    return false;
	}

}
