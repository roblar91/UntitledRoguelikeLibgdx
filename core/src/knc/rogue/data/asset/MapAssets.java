package knc.rogue.data.asset;

import com.badlogic.gdx.graphics.Texture;

public abstract class MapAssets {
    protected Texture[] floor;
    protected Texture[] wall;
    protected Texture entrance;
    protected Texture exit;

    public abstract Texture getFloor();
    public abstract Texture getWall();
    public abstract Texture getEntrance();
    public abstract Texture getExit();
}
