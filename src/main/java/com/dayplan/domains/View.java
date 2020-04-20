package com.dayplan.domains;

public final class View {

    public interface IdName{};

    public interface FullUser extends IdName{};

    public interface FullUserWithPass extends FullUser{}

}
