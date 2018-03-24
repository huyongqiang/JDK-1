/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.graalvm.compiler.core.common.calc;

import org.graalvm.compiler.debug.GraalError;

public enum FloatConvert {
    F2I(FloatConvertCategory.FloatingPointToInteger, 32),
    D2I(FloatConvertCategory.FloatingPointToInteger, 64),
    F2L(FloatConvertCategory.FloatingPointToInteger, 32),
    D2L(FloatConvertCategory.FloatingPointToInteger, 64),
    I2F(FloatConvertCategory.IntegerToFloatingPoint, 32),
    L2F(FloatConvertCategory.IntegerToFloatingPoint, 64),
    D2F(FloatConvertCategory.FloatingPointToFloatingPoint, 64),
    I2D(FloatConvertCategory.IntegerToFloatingPoint, 32),
    L2D(FloatConvertCategory.IntegerToFloatingPoint, 64),
    F2D(FloatConvertCategory.FloatingPointToFloatingPoint, 32);

    private final FloatConvertCategory category;
    private final int inputBits;

    FloatConvert(FloatConvertCategory category, int inputBits) {
        this.category = category;
        this.inputBits = inputBits;
    }

    public FloatConvertCategory getCategory() {
        return category;
    }

    public FloatConvert reverse() {
        switch (this) {
            case D2F:
                return F2D;
            case D2I:
                return I2D;
            case D2L:
                return L2D;
            case F2D:
                return D2F;
            case F2I:
                return I2F;
            case F2L:
                return L2F;
            case I2D:
                return D2I;
            case I2F:
                return F2I;
            case L2D:
                return D2L;
            case L2F:
                return F2L;
            default:
                throw GraalError.shouldNotReachHere();
        }
    }

    public int getInputBits() {
        return inputBits;
    }
}