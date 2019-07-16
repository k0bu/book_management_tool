package guiLayout;

import java.util.Stack;

public class SceneController {
  private Stack<Scene> _previousScenes;
  private Scene _activeScene;

  public Scene getPreviouuScene() {
    return this._previousScenes.pop();
  }

  public Scene getActiveScene() {
    return this._activeScene;
  }

  public void stackPreviousScene(Scene scene) {
    this._previousScenes.push(scene);
  }

  public void setPreviousScene(Scene scene){
    stackPreviousScene(scene);
  }

  public void setActiveScene(Scene scene) {
    this._activeScene = scene;
  }
}