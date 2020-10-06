package com.huskar_t.jdsl;

import com.huskar_t.util.GoString;
import com.sun.jna.Library;

public interface LibJDSL extends Library {
    String ParseJson(GoString.ByValue config);

    String Read(GoString.ByValue parseJsonResult, GoString.ByValue msg, GoString.ByValue extra);
}
