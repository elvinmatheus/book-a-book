package framework;

public abstract class Page extends View {

    protected App app;
    public Page() {
        super(null);
    }
    public Page(App app) {
        super(app);
        this.app = app;
    }
    public void init(App app) {
        this.app = app;
    }

    /** Retorna o título da página */
    public abstract String getTitle();
    
}
