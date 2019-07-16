package guiLayout;

public abstract class Scene{
    protected SceneController controller;
    
    public Scene(SceneController program){
        this.controller = program;
    }

    public abstract void show();

    public void changeScene(Scene nextScene){
        controller.setPreviousScene(this);
        controller.setActiveScene(nextScene);
    }


}