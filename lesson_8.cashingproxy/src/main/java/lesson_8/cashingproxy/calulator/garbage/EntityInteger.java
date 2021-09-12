package lesson_8.cashingproxy.calulator.garbage;

import java.io.Serializable;
import java.util.Objects;

public class EntityInteger implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer key;
    private Integer value;

    public EntityInteger() {
    }

    public EntityInteger(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityInteger)) return false;
        EntityInteger entity = (EntityInteger) o;
        return Objects.equals(key, entity.key) &&
                Objects.equals(value, entity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "EntityInteger{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
