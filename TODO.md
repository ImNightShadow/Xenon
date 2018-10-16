 Development team : 
 [Julio Lopes](https://www.linkedin.com/in/thejuliolopes/), 
 [Nuno Paz](https://www.linkedin.com/in/nuno-paz/), 
 [André Lopes](https://www.linkedin.com/in/andrejtlopes/), 
 [Gabriela F.](https://www.linkedin.com/in/gabriela-f-76445723/)  

Todo:
-
- [x] Project Skeleton

- [X] Draw Screen

- [X] Draw Player Ship
(PlayerShip, GameMap)

- [x] PlayerShip movement

- [x] Game class - André

- [x] Implement EnemyShipFactory
(EnemyShipFactory, EnemyShip) - Gabriela

- [x] Implement EnemyShip(s) and SpaceShip(s)
(EnemyShip, GameMap) - André

- [x] Implement Projectile(s)
(Projectile) - Julio

- [x] Implement ProjectileFactory
(ProjectileFactory, Projectile) - Gabriela

- [x] Ship(s) can shoot projectiles
(SpaceShip, ProjectileFactory, Game) - Julio

- [x] Implement CollisionDetection
(CollisionDetector, GameObject, SpaceShip) - Nuno

- [x] Gain points for destroying EnemyShip(s)
(Game, EnemyShip, PlayerShip, CollisionDetector) - Nuno

- [x] Implement obstacles
(new class)

- [x] Implement Power Ups
(new class)
  
- [x] All new EnemyShip(s) and Projectile(s) should be acquired via the *Factory so so objects can be reused.

- [x] The Game's main loop is in the Game class's run method. While the game is still running it will in turn call the methods for updating GameObject(s) positions, and calling the CollisionDetector. 
