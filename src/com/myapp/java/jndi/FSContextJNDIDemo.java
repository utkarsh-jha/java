package com.myapp.java.jndi;

import javax.naming.*;
import java.util.Hashtable;

class Monkey implements Referenceable {
    private String name;
    private String favoriteFruit;
    private boolean likesBanana;

    public Monkey() {
    }

    public Monkey(String name, String favoriteFruit, boolean likesBanana) {
        this.name = name;
        this.favoriteFruit = favoriteFruit;
        this.likesBanana = likesBanana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    public boolean isLikesBanana() {
        return likesBanana;
    }

    public void setLikesBanana(boolean likesBanana) {
        this.likesBanana = likesBanana;
    }

    @Override
    public Reference getReference() throws NamingException {
        Reference reference = new Reference(Monkey.class.getName());
        reference.add(new StringRefAddr("name", this.name));
        reference.add(new StringRefAddr("favoriteFruit", this.favoriteFruit));
        reference.add(new StringRefAddr("likesBanana", Boolean.toString(likesBanana)));
        return reference;
    }
}

public class FSContextJNDIDemo {
    public static void main(String[] args) throws Exception {
        Hashtable<String, String> environment = new Hashtable<>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        environment.put(Context.PROVIDER_URL, "file:/D:/");
        Context ctx = new InitialContext(environment);
        Monkey steven = new Monkey("steven", "banana", true);
        ctx.bind("steven", steven);
    }
}
