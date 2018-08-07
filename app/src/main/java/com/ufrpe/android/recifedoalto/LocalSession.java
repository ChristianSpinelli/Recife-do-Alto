package com.ufrpe.android.recifedoalto;

public class LocalSession {
    private static LocalSession sLocalSession;

    public Local getLocal() {
        return mLocal;
    }

    public void setLocal(Local local) {
        mLocal = local;
    }

    private Local mLocal;
    public static LocalSession get(){
        if ( sLocalSession==null){
            sLocalSession=new LocalSession();
        }
        return sLocalSession;
    }

}
