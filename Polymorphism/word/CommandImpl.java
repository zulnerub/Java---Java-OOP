package Polymorphism.word;

import java.util.*;

public class CommandImpl implements CommandInterface {


    class ToUpperTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    class ToCut implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            if (startIndex == endIndex){
                String removedText = "";
                CommandImpl.removedText = removedText;
            }else{
                String removedText = text.substring(startIndex, endIndex);
                CommandImpl.removedText = removedText;
                text.delete(startIndex, endIndex);

            }
        }
    }

    class ToPaste implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            if (startIndex == endIndex){
                text.insert(startIndex, CommandImpl.removedText);
            }else{
                text.replace(startIndex, endIndex, CommandImpl.removedText);
            }



        }
    }





    protected static String removedText = "";

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;


    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;

    }




    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new ToCut()));
        commands.add(new Command("paste", new ToPaste()));

        return commands;
    }
}
