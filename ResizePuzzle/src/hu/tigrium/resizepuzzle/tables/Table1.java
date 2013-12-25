package hu.tigrium.resizepuzzle.tables;


public class Table1 extends AbstractTable {
	private int xEgyseg, yEgyseg;
    
	public Table1(String imgPath, int width, int height) {
		super(imgPath, width, height);		
	}

	@Override
	void initFields() {
		if (image.getWidth() / image.getHeight() < 1) {
			xEgyseg = (int) ((double)image.getWidth() / 12);
			yEgyseg = (int) ((double)image.getHeight() / 20);
		} else {
			xEgyseg = (int) ((double)image.getWidth() / 20);
			yEgyseg = (int) ((double)image.getHeight() / 12);
		}
		
		fields = new Field[11];
		
		if (image.getWidth() / image.getHeight() < 1) {
			addField(0, image,
					0, 0, 
					3 * xEgyseg, 3 * yEgyseg);
			addField(1, image, 
					0, 3 * xEgyseg, 
					3 * xEgyseg, 3 * yEgyseg);
			addField(2, image, 
					0, 6 * xEgyseg, 
					3 * xEgyseg, 3 * yEgyseg);
			addField(3, image, 0, 9 * xEgyseg, 
					image.getWidth() - 9 * xEgyseg, 7 * yEgyseg);
			addField(4, image, 
					3 * yEgyseg, 0, 
					9 * xEgyseg, 4 * yEgyseg);
			addField(5, image, 
					7 * yEgyseg, 0, 
					5 * xEgyseg, 3 * yEgyseg);
			addField(6, image, 
					7 * yEgyseg, 5 * xEgyseg, 
					3 * xEgyseg, 5 * yEgyseg);
			addField(7, image, 
					7 * yEgyseg, 8 * xEgyseg, 
					image.getWidth() - 8 * xEgyseg, 5 * yEgyseg);
			addField(8, image, 
					10 * yEgyseg, 0, 
					5 * xEgyseg, 4 * yEgyseg);
			addField(9, image, 
					14 * yEgyseg, 0, 
					5 * xEgyseg, image.getHeight() - 14 * yEgyseg);
			addField(10, image, 
					12 * yEgyseg, 5 * xEgyseg, 
					image.getWidth() - 5 * xEgyseg, image.getHeight() - 12 * yEgyseg);
		} else {
			addField(0, image,
					3 * 3 * xEgyseg, 0, 
					3 * xEgyseg, 3 * yEgyseg);
			addField(1, image, 
					2 * 3 * xEgyseg, 0, 
					3 * xEgyseg, 3 * yEgyseg);
			addField(2, image, 
					3 * xEgyseg, 0, 
					3 * xEgyseg, 3 * yEgyseg);
			addField(3, image, 
					0, 0, 
					7 * xEgyseg, 3 * yEgyseg);
			addField(4, image, 
					3 * xEgyseg, 3 * yEgyseg,
					4 * xEgyseg, image.getHeight() - 3 * yEgyseg);
			addField(5, image, 
					7 * xEgyseg, 7 * yEgyseg, 
					3 * xEgyseg, image.getHeight() - 7 * yEgyseg);
			addField(6, image, 
					4 * xEgyseg, 7 * yEgyseg, 
					5 * xEgyseg, 3 * yEgyseg);
			addField(7, image, 
					0, 7 * yEgyseg, 
					5 * xEgyseg, 4 * yEgyseg);
			addField(8, image, 
					7 * xEgyseg, 10 * yEgyseg, 
					4 * xEgyseg, image.getHeight() - 7 * yEgyseg);
			addField(9, image, 
					7 * xEgyseg, 14 * yEgyseg, 
					image.getWidth() - 14 * xEgyseg, image.getHeight() - 7 * yEgyseg);
			addField(10, image, 
					0, 12 * yEgyseg, 
					image.getWidth() - 12 * xEgyseg, 7 * yEgyseg);
		}
	}
}
