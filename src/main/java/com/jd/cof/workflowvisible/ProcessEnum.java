package com.jd.cof.workflowvisible;


import java.util.HashMap;
import java.util.Map;

//wxc design 每一环节的名字应该是可以在“插件”里提供出来， 再由系统启动时取出来， 放到运行环境中。
public enum ProcessEnum {
    Start(-1,"Start","Start"),
    A(0,"A","A"),
    B(1,"B","B"),
    C(2,"C","C"),
    D(3,"D","D"),
    End(4,"End","End");

    // value
    private final int value;
    // text
    private final String text;
    // name
    private final String name;

    private ProcessEnum(int value, String text, String name) {
        this.value = value;
        this.text = text;
        this.name = name;
    }
    /**
     * get Value By Name
     * @param name
     * @return
     */
    public static int getValueByName(String name) {
        for (ProcessEnum processEnum : ProcessEnum.values()) {
            if (processEnum.name.equals(name)) {
                return processEnum.value;
            }
        }

        return -1;
    }

    public String getName() {
        return this.name;
    }
    public int getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }


    private static final Map<String, ProcessEnum> instanceRegister = new HashMap();

    static {
        for(ProcessEnum p: ProcessEnum.values()) {
            instanceRegister.put(p.getName(), p);
        }
    }

    public static ProcessEnum getInstanceByName(String name) {
        return instanceRegister.get(name);
    }

}
