package game.objects.ships;

public interface ShipBehavior {
    void markHit(int y, int x);
    boolean checkIsDead();
    void setRandomCoordinates();
    void fillBody();
}