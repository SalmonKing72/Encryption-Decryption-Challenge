class Publication {

    protected String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return String.format("%s%s", getType(), getDetails());
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return String.format(": %s", title);
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getType() {
        return "Newspaper";
    }

    @Override
    public String getDetails() {
        return String.format(" (source - %s): %s", source, title);
    }
}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getType() {
        return "Article";
    }

    @Override
    public String getDetails() {
        return String.format(" (author - %s): %s", author, title);
    }
}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getType() {
        return "Announcement";
    }

    @Override
    public String getDetails() {
        return String.format(" (days to expire - %s): %s", daysToExpire, title);
    }
}
