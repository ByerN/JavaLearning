package org.byern.javalearning.lesson6.lsystem.tree.service;

import org.byern.javalearning.lesson6.lsystem.core.constant.RuleConstants;
import org.byern.javalearning.lesson6.lsystem.core.dto.Frame;
import org.byern.javalearning.lesson6.lsystem.core.dto.Line;
import org.byern.javalearning.lesson6.lsystem.core.util.LineUtils;
import org.byern.javalearning.lesson6.lsystem.tree.constant.RuleAction;

import java.util.Properties;
import java.util.Stack;

/**
 * Created by ByerN on 05.03.2017.
 */
public class TreeGenerator {

    public Line[] create(String input,
                         int angle,
                         Properties properties) {
        return create(input, angle, 1, 0.0, 0.0, properties);
    }

    public Line[] create(String input,
                         int angle,
                         int lineLength,
                         double x,
                         double y,
                         Properties properties) {
        Line[] result = new Line[0];
        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(x, y, angle));
        result = create(input, lineLength, stack, result, properties);
        return result;
    }

    private Line[] create(String input,
                          int lineLength,
                          Stack<Frame> stack,
                          Line[] lines,
                          Properties properties) {
        Line[] result = lines;

        for (int n = 0; n < input.length(); n++) {
            Frame frame = stack.peek();
            char symbol = input.charAt(n);
            RuleAction ruleAction = RuleAction.getBySymbol(symbol);

            if (ruleAction != null) {
                switch (ruleAction) {
                    case DRAW_LINE:
                    case DRAW_LINE_END_AS_LEAF:
                        Line line = LineUtils.createLine(
                                frame.getX(),
                                frame.getY(),
                                frame.getAngle(),
                                lineLength
                        );
                        result = LineUtils.addLine(
                                result,
                                line
                        );
                        frame.setX(line.getEndPoint().getX());
                        frame.setY(line.getEndPoint().getY());
                        break;
                    case PUSH_POSITION:
                        stack.push(new Frame(frame.getX(), frame.getY(), frame.getAngle()));
                        break;
                    case POP_POSITION:
                        if (stack.size() > 1) {
                            stack.pop();
                        }
                        break;
                    case TURN_LEFT:
                        frame.setAngle(frame.getAngle() - getTurnAngle(properties));
                        break;
                    case TURN_RIGHT:
                        frame.setAngle(frame.getAngle() + getTurnAngle(properties));
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }
        return result;
    }

    private double getTurnAngle(Properties properties) {
        double result = 0;
        try {
            result = properties.containsKey(RuleConstants.TURN_ANGLE_NAME) ?
                    Double.parseDouble(properties.getProperty(RuleConstants.TURN_ANGLE_NAME)) : 0;
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return result;
    }


}
