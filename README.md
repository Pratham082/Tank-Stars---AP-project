# ⭐ Tank Stars

### Welcome to our Tank Stars Game! 🎯

# Introduction

The following showcases glimpse of a clone of the mobile game ‘Tank Stars’, recreated using LibGdx and Scene2D Engine, employing important OOPs such as:

- Inheritance & Interfaces
- Encapsulation
- Polymorphism
- Abstraction
- JUnit Testing
- Serialisation
- Design Patterns
- Exception Handling

# 🎮 Game Play

## Main Menu Screen

![Initial_Page.png](https://github.com/UtsvGrg/TankStars-GameClone/blob/main/Initial%20Page.png)
<image>

## Tank Selection Screen

The Game comprises of 3 tanks, each having one special attack.

![User_Page.png](https://github.com/UtsvGrg/TankStars-GameClone/blob/main/User_Page.png)

## Main Game Screen

### Shooting

- Each Tank are separate textures that have been attached together using their relative positions, whereas the background and ground have been rendered using sprite.
- Each stage enables ScreenViewport and thereby allows resizing the entire game.
- Health of the tank hit is reduced depending upon the distance of the impact of the weapon.

# Load Game Screen

- Games can be saved and loaded from the Load option present in the Main Menu
- Games are stored using the concept of Serialisation using `ObjectOutputStream`.
- All game details of an ongoing game can be stored on multiple slots, from out1.txt to out3.txt.

```java
        Button1.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(new FileOutputStream("out1.txt"));
                    out.writeObject(game);
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                game.setScreen(new MenuScreen(game));
            }
        });
```

- The class Play is serialised and the next slot index is stored using `FileOutputStream`.
- Finally, games are Loading using `ObjectInputStream`

```java
        Button2.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(new FileInputStream("out2.txt"));
                    game1 = (TankWars) in.readObject();
                    in.close();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
```

![Saved_Game.png](https://github.com/UtsvGrg/TankStars-GameClone/blob/main/Saved_Game(Serialization).png)

## Exception Handling

- We have handled many exceptions, to ensure that the game runs smoothly from IOException to ClassNotFoundException.

## Use case Diagram

The following use case diagram shows the work flow of the game.

![Use Case Diagram - Tank Stars.png](https://github.com/UtsvGrg/TankStars-GameClone/blob/main/UML_Photo.png)
