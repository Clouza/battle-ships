# Battle Ships
Game with console interface and based on guess game. Also this is a project for august 2022.

## Getting started
clone the project using git clone or you can download with [zip](https://github.com/Clouza/battle-ships/archive/refs/heads/master.zip)
```
git clone https://github.com/Clouza/battle-ships.git
``` 

## Configuration
You can change the [configuration](https://github.com/Clouza/battle-ships/blob/master/src/com/clouza/battleships/Configuration.java) file.
### Details
| Type | Name | Value | Description |
| ----------- | ----------- | ----------- | ----------- |
| String | USER_SHIPS | @ | This is symbol for user ships |
| String | COMPUTER_SHIPS | 2 | This is symbol for computer ships |
| String | USER_SHIP_DESTROYED | x | This is the symbol for the destroyed user ship |
| String | COMPUTER_SHIP_DESTROYED | ! | This is the symbol for the destroyed computer ship |
| String | MISSED | - | User missed the coordinate |
| String | COMPUTER_MISSED | * | Computer missed the coordinate |
| String | BORDER | ---------- | Border to separate messages |
| Integer | SIZE | 10 | The default is 10, you can increase it |
| Integer | MAX_GUESS | 0 | The default is 0, you can increase it |

## Features
- The computer can avoid the already guessed coordinates or ships.
- The larger the SIZE added, the amount of the ships will be adjusted.
- Can avoid float & negative values.
- The map and score are auto updated.

## Contributing
There is no contributing available.

## License
To be confirmed.
