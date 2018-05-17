package com.example.akashravi.vriksha;

public class tender_add {

        public String pname;
        public String addr;
        public String ph;
        public int qt;
        public int dr;
        public int id;
        public String uid;

        // Default constructor required for calls to
        // DataSnapshot.getValue(User.class)
        public tender_add() {
        }

        public tender_add(String pname, String addr, String ph, int qt, int dr, String uid) {
            this.pname = pname;
            this.addr = addr;
            this.ph=ph;
            this.qt=qt;
            this.dr=dr;
            this.uid=uid;
        }

    public Object getId() {
              return  id;
    }
}
