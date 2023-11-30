package com.infovass.catering.MyFormat.MyDM;

import java.util.ArrayList;

public class NewItem {

        private ArrayList<Catering> Gathering;

        private ArrayList<Catering> Catering;

        public ArrayList<Catering> getGathering ()
        {
            return Gathering;
        }

        public void setGathering (ArrayList<Catering> Gathering)
        {
            this.Gathering = Gathering;
        }

        public ArrayList<Catering> getCatering ()
        {
            return Catering;
        }

        public void setCatering (ArrayList<Catering> Catering)
        {
            this.Catering = Catering;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [Gathering = "+Gathering+", Catering = "+Catering+"]";
        }

}
