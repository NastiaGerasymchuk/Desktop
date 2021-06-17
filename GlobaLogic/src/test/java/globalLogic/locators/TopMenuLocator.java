package globalLogic.locators;

public class TopMenuLocator implements BaseNav {
    private static String CSS_LI_ITEM="body > div.master-wrapper-page > div.master-wrapper-content > div.header-menu > ul.top-menu > li:nth-child(%d)";

    public String getItemLocator(int item) {
        return String.format(CSS_LI_ITEM, item);
    }
}
