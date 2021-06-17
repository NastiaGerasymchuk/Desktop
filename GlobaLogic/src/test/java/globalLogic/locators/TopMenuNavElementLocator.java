package globalLogic.locators;

public class TopMenuNavElementLocator implements BaseNavMultiple {
    private static String CSS_LI_ITEM="body > div.master-wrapper-page > div.master-wrapper-content > div.header-menu > ul.top-menu > li:nth-child(%d) > ul > li:nth-child(%d)";


    @Override
    public String getItemMultipleLocator(int navItem, int child) {
        return String.format(CSS_LI_ITEM, navItem,child);
    }
}
