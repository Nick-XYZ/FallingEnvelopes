package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        char playerCharacter = '\u263a';
        Position player = new Position(40,23);
        terminal.setCursorPosition(player.x, player.y);
        terminal.putCharacter(playerCharacter);


        char monsterCharacter = '\u2709';
        Position monster = new Position(23,1);
        terminal.setCursorPosition(monster.x, monster.y);
        terminal.putCharacter(monsterCharacter);


        List<MonsterEnvelope> monsters = new ArrayList<>();
        monsters.add(new MonsterEnvelope(3, 1));
        monsters.add(new MonsterEnvelope(13, 1));
        monsters.add(new MonsterEnvelope(23, 1));
        monsters.add(new MonsterEnvelope(5, 1));




        boolean continueReadingInput = true;
        while (continueReadingInput) {
            KeyStroke keyStroke = null;

            do {
                keyStroke = terminal.pollInput();
            }
            while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter(); // used Character instead of char because it might be null
            if (c == Character.valueOf('q')) {
                continueReadingInput = false;
                System.out.println("quit");
                terminal.close();
            }

            Position oldPosition = new Position(player.x, player.y);

            switch (keyStroke.getKeyType()) {
                case ArrowRight:
                    player.x += 2;
                    break;
                case ArrowLeft:
                    player.x -= 2;
                    break;
            }

            terminal.setCursorPosition(oldPosition.x, oldPosition.y);
            terminal.putCharacter(' ');
            terminal.setCursorPosition(player.x, player.y);
            terminal.putCharacter(playerCharacter);

            terminal.flush();


        }
    }


}