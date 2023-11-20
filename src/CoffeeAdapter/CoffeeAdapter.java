package CoffeeAdapter;

public class CoffeeAdapter implements CoffeeArt {
    private AdvancedCoffeeAdapter advancedCoffeeAdapter;

    public void setAdvancedImgViewer(AdvancedCoffeeAdapter advancedImgViewer) {
        this.advancedCoffeeAdapter = advancedCoffeeAdapter;
    }

    public CoffeeAdapter(AdvancedCoffeeAdapter advancedCoffeeAdapter) {
        this.advancedCoffeeAdapter = advancedCoffeeAdapter;
    }

    @Override
    public String draw() {
        return advancedCoffeeAdapter.drawTulip() + advancedCoffeeAdapter.drawHeart();
    }
}
