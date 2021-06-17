package globalLogic.locators;

public class ProductItemLocator {
    public static final String CSS_ITEM_BOX="body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div.page.category-page > div.page-body > div.product-grid > div";
    private static String CSS_ADD_TO_CARD_BUTTON="body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div.page.category-page > div.page-body > div.product-grid > div:nth-child(%d) > div > div.details > div.add-info > div.buttons > input";

    public static String getItemLocator(int item) {
        return String.format(CSS_ADD_TO_CARD_BUTTON, item);
    }
}
