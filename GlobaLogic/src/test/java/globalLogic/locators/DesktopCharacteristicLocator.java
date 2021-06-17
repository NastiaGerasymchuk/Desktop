package globalLogic.locators;

public class DesktopCharacteristicLocator implements BaseNavMultiple {
    private static final String XPATH_UL_CHARACTERISTIC = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[6]/dl/dd[%d]/ul/li[%d]/input";
    public static final String CSS_DESKTOP_PRICE="#product-details-form > div > div.product-essential > div.overview > div.prices > div > span";


    @Override
    public String getItemMultipleLocator(int navItem, int child) {
        return String.format(XPATH_UL_CHARACTERISTIC, navItem,child);
    }
}
