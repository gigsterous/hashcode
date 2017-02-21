/**
 * Created by michalsvacha on 21.02.17.
 */
public class Slice {
    int originX;
    int originY;
    int endX;
    int endY;

    int tomatoCount = 0;
    int mushroomCount = 0;

    public Slice(int originX, int originY, char ingredient) {
        this.originX = originX;
        this.originY = originY;
        this.endX= originX;
        this.endY = originY;
        this.addIngredient(ingredient);
    }

    public int size() {
        return (endX - originX) * (endY - originY);
    }

    public void addIngredient(char ingredient) {
        if (ingredient == 'T') {
            tomatoCount++;
        } else {
            mushroomCount++;
        }
    }
    
    public void updateIngredients(char[][] pizza) {
        tomatoCount = 0;
        mushroomCount = 0;

        for (int i = originX; i < endX; i++) {
            for (int j = originY; j < endY; j++) {
                addIngredient(pizza[i][j]);
            }
        }
    }

    public boolean isComplete(int constraint) {
        return tomatoCount >= constraint && mushroomCount >= constraint;
    }

    /**
     * Getters & Setters
     */

    public int getOriginX() {
        return originX;
    }

    public void setOriginX(int originX) {
        this.originX = originX;
    }

    public int getOriginY() {
        return originY;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getTomatoCount() {
        return tomatoCount;
    }

    public void setTomatoCount(int tomatoCount) {
        this.tomatoCount = tomatoCount;
    }

    public int getMushroomCount() {
        return mushroomCount;
    }

    public void setMushroomCount(int mushroomCount) {
        this.mushroomCount = mushroomCount;
    }
}
