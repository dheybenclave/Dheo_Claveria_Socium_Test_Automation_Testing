package utils;

public enum ConstantsURL {

    //WEB APPLICATION URL SERVERS////////////////////////////////////////////////////////////////////////////////////////////
    WEB_APP_DEMO_ASPAWESOME("https://demo.aspnetawesome.com/"),
    WEB_APP_WIKIPEDIA("https://wikipedia.org"),
    WEB_APP_AMAYSIM("https://accounts.amaysim.com.au/identity/login"),

    //JSON API URL SERVERS////////////////////////////////////////////////////////////////////////////////////////////
    JSON_API_LOCALHOST("http://localhost:3000");

    public final String url;

    // getter method
    public String getURL() {
        return this.url;
    }

    // enum constructor - cannot be public or protected
    ConstantsURL(String url) {
        this.url = url;
    }

}
