package com.single.mode;

/**
 * 枚举方式：
 * 枚举类型不允许被继承，同时也是线程安全的，且只能被实例化一次，但是枚举类型不能够进行懒加载, 但可以使用 Holder 的方式进行懒加载
 */
public class EnumSingleMode {

    private EnumSingleMode() {

    }

    private enum EnumHolder {
        INSTANCE;
        private EnumSingleMode instance;

        EnumHolder() {
            this.instance = new EnumSingleMode();
        }

        private EnumSingleMode getEnumSingleMode() {
            return instance;
        }
    }

    private static EnumSingleMode getEnumSingleMode() {
        return EnumHolder.INSTANCE.getEnumSingleMode();
    }
}
