package de.SweetCode.SteamAPI.method.option;

import de.SweetCode.SteamAPI.method.SteamMethod;

/**
 * <p>
 *    Steam Web API {@link SteamMethod SteaMethods} need to provide options (or parameters)
 *    when called, and these options have types. This enum represents a list of all allowed option types.
 * </p>
 */
public enum OptionTypes implements OptionType {

    /**
     * <p>
     *    Represents a STRING (String) in the Steam Web API and is internally represented by a {@link String}.
     * </p>
     */
    STRING {

        @Override
        public String getName() {
            return "String";
        }

        @Override
        public boolean check(Object value) {

            return (
                !(value == null) &&
                (value instanceof String)
            );

        }

        @Override
        public String parse(Object value) {
            return (String) value;
        }

    },
    /**
     * <p>
     *    Represents an UINT_32 (unsigned 32bit integer) in the Steam Web API, but is internally represented by a {@link Long}
     *    since Java does not support unsigned-integers. To still keep the "unsigned" property of unsigned ints, the method
     *    {@link OptionType#parse(Object)} calls {@link Math#abs(long)} to only provide positive values.
     * </p>
     */
    UINT_32 {

        @Override
        public String getName() {
            return "uint32";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof Long) &&
                ((long) value <= 0xFFFFFFFF) //-> The max value of a uint is 4294967295 or as hex 0xFFFFFFFF
            );
        }

        @Override
        public Long parse(Object value) {
            return Math.abs((long) value);
        }

    },
    /**
     * <p>
     *    Represents an UINT_64 (unsigned 64bit integer) in the Steam Web API, but is internally represented by a {@link Long}
     *    since Java does not support unsigned-integers. To still keep the "unsigned" property of unsigned ints, the method
     *    {@link OptionType#parse(Object)} calls {@link Math#abs(long)} to only provide positive values.
     * </p>
     */
    UINT_64 {

        @Override
        public String getName() {
            return "uint64";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof Long)
            );
        }

        @Override
        public Object parse(Object value) {
            return Math.abs((long) value);
        }

    },
    /**
     * <p>
     *    Represents an INT_32 (signed 32bit integer) in the Steam Web API and is internally represented by an {@link Integer}.
     * </p>
     */
    INT_32 {

        @Override
        public String getName() {
            return "int32";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof Integer)
            );
        }

        @Override
        public Integer parse(Object value) {
            return (int) value;
        }

    },
    /**
     * <p>
     *    Represents an INT_64 (signed 64bit integer) in the Steam Web API, but is internally represented by a {@link Long}
     *    since Java doesn't have directly 64bit integers, they are called long internally.
     * </p>
     */
    INT_64 {

        @Override
        public String getName() {
            return "int64";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof Long)
            );
        }

        @Override
        public Long parse(Object value) {
            return (long) value;
        }

    },
    /**
     * <p>
     *    Represents a FLOAT in the Steam Web API and is also internally represented by a {@link Float}.
     * </p>
     */
    FLOAT {

        @Override
        public String getName() {
            return "float";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof Float)
            );
        }

        @Override
        public Float parse(Object value) {
            return (float) value;
        }

    },
    /**
     * <p>
     *    Represents a BOOL (boolean) in the Steam Web API and is also internally represented by a {@link Boolean}.
     * </p>
     */
    BOOL {

        @Override
        public String getName() {
            return "bool";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof Boolean)
            );
        }

        @Override
        public Boolean parse(Object value) {
            return (boolean) value;
        }

    },
    /**
     * <p>
     *    Represents RAW BINARY in the Steam Web API and is internally represented by a {@link Byte[]}.
     * </p>
     */
    RAW_BINARY {

        @Override
        public String getName() {
            return "raw-binary";
        }

        @Override
        public boolean check(Object value) {
            return (
                !(value == null) &&
                (value instanceof byte[])
            );
        }

        @Override
        public byte[] parse(Object value) {
            return (byte[]) value;
        }

    }

}
