package no.hiof.jornhl.robocode.BackUpAdvanced;


import robocode.*;

import java.awt.*;


public class Gunther extends AdvancedRobot {
    //static Point2D.Double[] enemyPoints;
    //int count;

    private boolean movingForward;

    private int numberOfVictims;
    String targetName;


    @Override
    public void run() {
        //enemyPoints = new Point2D.Double[numberOfVictims];

        pimpMyRide();
        setAdjustGunForRobotTurn(true);
        out.println("LOVE AND TOLERANCE!");

        while (true) {
            numberOfVictims = getOthers();
            out.println(numberOfVictims);

            if (Math.random() < 0.5) {
                setTurnRight(Math.random() * 360);

            } else {
                setTurnLeft(Math.random() * 360);
            }

            setTurnGunRight(5000);
            //turnGunRight(360);
            //setAhead((Math.random() * 200) + 500);
            setAhead(5000);
            movingForward = true;
            waitFor(new TurnCompleteCondition(this));
        }
    }


    /*
        =========================================
        ===            ACTIONS                ===
        =========================================
    */
    public void defensiveMode() {

    }

    public void offensiveMode() {

    }



    /*
        =========================================
        ===           REACTIONS               ===
        =========================================
    */
    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        //  Be less aggressive with fewer enemies?
        //  Less chance of hitting something with stray bullets.

        if (e.getDistance() < 100) {
            fire(3);
        } else if (e.getDistance() < 300) {
            //turnGunRight(e.getBearing());
            fire(2);
        } else {
            //turnGunRight(e.getBearing());
            //turnGunRight(e.getBearing() - getGunHeading());
            fire(1);
        }
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        //panicMove();
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        if (movingForward) {
            movingForward = false;
            back(50);
            turnRight(100);
        } else {
            movingForward = true;
            ahead(50);
            turnRight(100);
        }
    }

    public void onHitRobot(HitRobotEvent e) {
        if (e.isMyFault()) {
            out.println("Sorry, my bad.");
        } else {
            out.println("roody poo!");
        }

        panicMove();
    }

    /*
        =========================================
        ===             UTIL                  ===
        =========================================
    */
    public void panicMove() {
        /*if (Math.random() < 0.5) {
            ahead((Math.random() * 40) + 18);
        } else {
            back((Math.random() * 40) + 18);
        }*/

        movingForward = false;
        back(50);
    }


    /*
        =========================================
        ===            ONE-OFFS               ===
        =========================================
    */
    public void pimpMyRide() {
        setBodyColor(Color.black);
        setGunColor(Color.red);
        setRadarColor(Color.black);
        setBulletColor(Color.white);
        setScanColor(Color.green);
    }


    /*
        =========================================
        ===           GOBSHITE                ===
        =========================================
    */
    /**
     * Method for petty, spiteful vengeance. Critically important!
     *
     * @param name Superfluous?
     */
    public void vengeance(String name) {
        /*
        Alright
        Let's Go

        You've hated me from childhood
        You sent me far away
        but I came back with vengeance
        and now I'll make you pay !

        You told me to be quiet
        you nailed me to the floor
        Now pain and retribution
        are knocking on your door !

        Yeah !
        Vengeance !

        Pain and retribution, knocking on your door !
        All the people fear me
        The universe is mine
        Obliterate your planet
        My power is divine!

        Here comes Armageddon
        you know it's all a farce
        to face a hundred billion tons
        of mechanized assault !

        Here comes Armageddon
        Soon the universe belongs to me !
        Yeah !
        Oh, Come on !
        Face a hundred billion tons of mechanized assault

        Power beyond reckoning, Overwhelming Force
        Power beyond reckoning, nothing will deter me from my course !

        Ravaging accross the galaxies
        Harbingers of famine and disease
        Army of Apocalypse and Doom
        We'll take your planet soon !

        The ship is fully loaded
        there's nothing left to kill
        Freight limit exceeded
        but we are hungry still

        We'll hunt for new horizons
        beyond the atmosphere
        New places to conquer,
        Interstellar Warfare oh yeah !

        Ravaging accross the galaxies
        Harbingers of famine and disease
        Army of Apocalypse and Doom
        We'll take your planet soon ! (It's ours !)
        Army of Apocolypse and Doom!
        */
    }
}