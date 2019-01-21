package frc.team2606.robot.refs;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import frc.team2606.robot.FieldMap;

public class ArmMapping {
    public Map<Integer, String> armMap = new HashMap<Integer, String>(540);
    DecimalFormat df = new DecimalFormat("#.#####");

    public void armMapInit(){
        for (int i = 0; i<=180; i++){
            armMap.put(i, "Length;" + df.format((FieldMap.ARM_LENGTH*Math.sin(i*(Math.PI/180)))) + ":Height;" + df.format((FieldMap.ARM_LENGTH*Math.cos(i*(Math.PI/180)))));
        }
    }

    public String armPos(int i){
        return armMap.get(i);
    }
}