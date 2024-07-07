# ⭐ Tank Stars

### Welcome to our game, Tank Stars! 🎯
made by: Utsav Garg, and Pratham Singhal; IIITD, as Advanced Programming endsem project

#Preface

Here is a sneak peek at a clone of the popular mobile game "Tank Stars," which was made with the help of LibGdx and Scene2D Engine. It uses significant OOPs like:

- Design Patterns - Exception Handling - Polymorphism - Abstraction - JUnit Testing - Inheritance & Interfaces - Encapsulation -

# 🎮 How to Play the Game

## Main Screen with Menu

![Initial_Page.png](https://github.com/Pratham082/Tank-Stars---AP-project/blob/main/Initial%20Page.png)
<image>


## Tank Selection Screen

There are three tanks in the game, and they each have one unique assault.

![User_Page.png](https://github.com/Pratham082/Tank-Stars---AP-project/blob/main/User_Page.png)
<image>
## Main Screen of the Game

### Action Shooting

- The background and ground have been created using sprites, however each Tank is a separate texture that has been joined together using their relative locations.
Every stage activates ScreenViewport, which permits the game to be resized in its entirety.
- Depending on how far the weapon impacts, the tank's health is diminished.

#Open the Game Screen

- The Main Menu's Load option allows you to save and load games.
- The idea of serialization is used to store games via `ObjectOutputStream`.
- An ongoing game's whole set of game information can be kept on several slots, ranging from out1.txt to out3.txt.

```java
 Button1.addListener(new ClickListener() { public void clicked(InputEvent event, float x, float y) { ObjectOutputStream out = null; { out = new ObjectOutputStream(new FileOutputStream("out1.txt")); out.writeObject(game); out.close(); IOException e) { IOException e) { IOException e) { IOException e) { IOException e) { IOException e) { IOException e) { IOException e) { IOException e) { game.setScreen(new MenuScreen(game));
```
- The class Play is serialized, and `FileOutputStream` is used to record the next slot index.
- At last, games are loading through the use of `ObjectInputStream}

```java
Button2.addListener(new ClickListener() { public void clicked(InputEvent event, float x, float y) { ObjectInputStream in = null; catch (IOException | ClassNotFoundException e) { in = new ObjectInputStream(new FileInputStream("out2.txt")); game1 = (TankWars) in.readObject(); in.close(); catch (IOException | ClassNotFoundException e) { throw new RuntimeException(e);
```

![Saved_Game.png](Source: TankStars-GameClone github.com/UtsvGrg/blob/main/Saved_Game(Serialization).png)

## Managing Exceptions

- From IOException to ClassNotFoundException, we have managed a lot of exceptions to make sure the game functions properly.

## Use Case Illustration

The game's workflow is displayed in the use case diagram that follows.

![Use Case Diagram - Tank Stars.png](https://github.com/Pratham082/Tank-Stars---AP-project/blob/main/UML_Photo.png)
