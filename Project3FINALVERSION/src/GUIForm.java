/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.Timer;

/**
 *
 * @author Ryan
 */
public class GUIForm extends javax.swing.JFrame {


    /**
     * Creates new form GUIForm
     */
    public GUIForm() throws IOException {
        initComponents();
    }

    process run = new process();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {


        int delay = 1000;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                mineralCount.setText(Integer.toString(run.getMineralCount()));
                gasCount.setText(Integer.toString(run.getGasCount()));
                timeCount.setText(Integer.toString(run.getMinutes())+" mins "+Integer.toString(run.getSeconds())+ " secs");

            }
        };

        new Timer(delay, taskPerformer).start();

        materialContainer = new javax.swing.JPanel();
        mineralLabel = new javax.swing.JLabel();
        gasLabel = new javax.swing.JLabel();
        mineralCount = new javax.swing.JLabel();
        gasCount = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeCount = new javax.swing.JLabel();
        nexusButton = new javax.swing.JButton();
        probeButton = new javax.swing.JButton();
        pylonButton = new javax.swing.JButton();
        assimilatorButton = new javax.swing.JButton();
        gatewayButton = new javax.swing.JButton();
        cyberneticsButton = new javax.swing.JButton();
        roboticsFacButton = new javax.swing.JButton();
        stargateButton = new javax.swing.JButton();
        templarButton = new javax.swing.JButton();
        twilightButton = new javax.swing.JButton();
        shrineButton = new javax.swing.JButton();
        roboticsBayButton = new javax.swing.JButton();
        unitLabel = new javax.swing.JLabel();
        buildingLabel = new javax.swing.JLabel();
        zealotBurron = new javax.swing.JButton();
        stalkerButton = new javax.swing.JButton();
        sentryButton = new javax.swing.JButton();
        observerButton = new javax.swing.JButton();
        immortalButton = new javax.swing.JButton();
        phoenixButton = new javax.swing.JButton();
        answerChoiceText = new javax.swing.JTextField();
        voidRayButton = new javax.swing.JButton();
        colossiButton = new javax.swing.JButton();
        highButton = new javax.swing.JButton();
        darkButton = new javax.swing.JButton();
        carrierButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameStateArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Starcraft II Optimiser GUI");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(85, 85, 85));

        materialContainer.setBackground(new java.awt.Color(255, 255, 255));

        mineralLabel.setText("Minerals:");

        gasLabel.setText("Vespene Gas:");

        mineralCount.setText("0");

        gasCount.setText("0");

        timeLabel.setText("Game Time:");

        timeCount.setText("0 mins 0 secs");

        javax.swing.GroupLayout materialContainerLayout = new javax.swing.GroupLayout(materialContainer);
        materialContainer.setLayout(materialContainerLayout);
        materialContainerLayout.setHorizontalGroup(
            materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeLabel)
                    .addComponent(mineralLabel)
                    .addComponent(gasLabel))
                .addGap(18, 18, 18)
                .addGroup(materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gasCount)
                    .addComponent(mineralCount)
                    .addComponent(timeCount))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        materialContainerLayout.setVerticalGroup(
            materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(timeCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mineralLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mineralCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(materialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gasLabel)
                    .addComponent(gasCount))
                .addGap(21, 21, 21))
        );
        nexusButton.setBackground(new java.awt.Color(85, 85, 85));
        nexusButton.setForeground(new java.awt.Color(20, 41, 149));
        nexusButton.setText("Nexus");
        nexusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nexusButtonActionPerformed(evt);
            }
        });

        probeButton.setBackground(new java.awt.Color(85, 85, 85));
        probeButton.setForeground(new java.awt.Color(20, 41, 149));
        probeButton.setText("Probe");
        probeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probeButtonActionPerformed(evt);
            }
        });

        pylonButton.setBackground(new java.awt.Color(85, 85, 85));
        pylonButton.setForeground(new java.awt.Color(20, 41, 149));
        pylonButton.setText("Pylon");
        pylonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pylonButtonActionPerformed(evt);
            }
        });

        assimilatorButton.setBackground(new java.awt.Color(85, 85, 85));
        assimilatorButton.setForeground(new java.awt.Color(20, 41, 149));
        assimilatorButton.setText("Assimilator");
        assimilatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assimilatorButtonActionPerformed(evt);
            }
        });

        gatewayButton.setBackground(new java.awt.Color(85, 85, 85));
        gatewayButton.setForeground(new java.awt.Color(20, 41, 149));
        gatewayButton.setText("Gateway");
        gatewayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gatewayButtonActionPerformed(evt);
            }
        });

        cyberneticsButton.setBackground(new java.awt.Color(85, 85, 85));
        cyberneticsButton.setForeground(new java.awt.Color(20, 41, 149));
        cyberneticsButton.setText("Cybernetics Core");
        cyberneticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cyberneticsButtonActionPerformed(evt);
            }
        });

        roboticsFacButton.setBackground(new java.awt.Color(85, 85, 85));
        roboticsFacButton.setForeground(new java.awt.Color(20, 41, 149));
        roboticsFacButton.setText("Robotics Facility");
        roboticsFacButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roboticsFacButtonActionPerformed(evt);
            }
        });

        stargateButton.setBackground(new java.awt.Color(85, 85, 85));
        stargateButton.setForeground(new java.awt.Color(20, 41, 149));
        stargateButton.setText("Stargate");
        stargateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stargateButtonActionPerformed(evt);
            }
        });

        templarButton.setBackground(new java.awt.Color(85, 85, 85));
        templarButton.setForeground(new java.awt.Color(20, 41, 149));
        templarButton.setText("Templar Archives");
        templarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templarButtonActionPerformed(evt);
            }
        });

        twilightButton.setBackground(new java.awt.Color(85, 85, 85));
        twilightButton.setForeground(new java.awt.Color(20, 41, 149));
        twilightButton.setText("Twilight Council");
        twilightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twilightButtonActionPerformed(evt);
            }
        });

        shrineButton.setBackground(new java.awt.Color(85, 85, 85));
        shrineButton.setForeground(new java.awt.Color(20, 41, 149));
        shrineButton.setText("Dark Shrine");
        shrineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shrineButtonActionPerformed(evt);
            }
        });

        roboticsBayButton.setBackground(new java.awt.Color(85, 85, 85));
        roboticsBayButton.setForeground(new java.awt.Color(20, 41, 149));
        roboticsBayButton.setText("Robotics Bay");
        roboticsBayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roboticsBayButtonActionPerformed(evt);
            }
        });

        unitLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        unitLabel.setText("UNITS");

        buildingLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buildingLabel.setText("BUILDINGS AND PROBES");

        zealotBurron.setBackground(new java.awt.Color(85, 85, 85));
        zealotBurron.setForeground(new java.awt.Color(20, 41, 149));
        zealotBurron.setText("Zealot");
        zealotBurron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zealotBurronActionPerformed(evt);
            }
        });

        stalkerButton.setBackground(new java.awt.Color(85, 85, 85));
        stalkerButton.setForeground(new java.awt.Color(20, 41, 149));
        stalkerButton.setText("Stalker");
        stalkerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stalkerButtonActionPerformed(evt);
            }
        });

        sentryButton.setBackground(new java.awt.Color(85, 85, 85));
        sentryButton.setForeground(new java.awt.Color(20, 41, 149));
        sentryButton.setText("Sentry");
        sentryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentryButtonActionPerformed(evt);
            }
        });

        observerButton.setBackground(new java.awt.Color(85, 85, 85));
        observerButton.setForeground(new java.awt.Color(20, 41, 149));
        observerButton.setText("Observer");
        observerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observerButtonActionPerformed(evt);
            }
        });

        immortalButton.setBackground(new java.awt.Color(85, 85, 85));
        immortalButton.setForeground(new java.awt.Color(20, 41, 149));
        immortalButton.setText("Immortal");
        immortalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                immortalButtonActionPerformed(evt);
            }
        });

        phoenixButton.setBackground(new java.awt.Color(85, 85, 85));
        phoenixButton.setForeground(new java.awt.Color(20, 41, 149));
        phoenixButton.setText("Phoenix");
        phoenixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoenixButtonActionPerformed(evt);
            }
        });

        answerChoiceText.setText("jTextField1");

        voidRayButton.setBackground(new java.awt.Color(85, 85, 85));
        voidRayButton.setForeground(new java.awt.Color(20, 41, 149));
        voidRayButton.setText("Void Ray");
        voidRayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voidRayButtonActionPerformed(evt);
            }
        });

        colossiButton.setBackground(new java.awt.Color(85, 85, 85));
        colossiButton.setForeground(new java.awt.Color(20, 41, 149));
        colossiButton.setText("Colossi");
        colossiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colossiButtonActionPerformed(evt);
            }
        });

        highButton.setBackground(new java.awt.Color(85, 85, 85));
        highButton.setForeground(new java.awt.Color(20, 41, 149));
        highButton.setText("High Templar");
        highButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highButtonActionPerformed(evt);
            }
        });

        darkButton.setBackground(new java.awt.Color(85, 85, 85));
        darkButton.setForeground(new java.awt.Color(20, 41, 149));
        darkButton.setText("Dark Templar");
        darkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButtonActionPerformed(evt);
            }
        });

        carrierButton.setBackground(new java.awt.Color(85, 85, 85));
        carrierButton.setForeground(new java.awt.Color(20, 41, 149));
        carrierButton.setText("Carrier");
        carrierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrierButtonActionPerformed(evt);
            }
        });
        gameStateArea.setColumns(20);
        gameStateArea.setRows(5);
        jScrollPane1.setViewportView(gameStateArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buildingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(443, 443, 443))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(answerChoiceText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(assimilatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nexusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gatewayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(probeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pylonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cyberneticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(roboticsFacButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stargateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(twilightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(templarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(shrineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roboticsBayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(darkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(carrierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(unitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(zealotBurron, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(stalkerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sentryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(observerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(immortalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(phoenixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(voidRayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(colossiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(highButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(materialContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(answerChoiceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buildingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nexusButton)
                    .addComponent(probeButton)
                    .addComponent(pylonButton)
                    .addComponent(zealotBurron)
                    .addComponent(stalkerButton)
                    .addComponent(sentryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assimilatorButton)
                    .addComponent(gatewayButton)
                    .addComponent(cyberneticsButton)
                    .addComponent(observerButton)
                    .addComponent(immortalButton)
                    .addComponent(phoenixButton))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(twilightButton)
                    .addComponent(stargateButton)
                    .addComponent(roboticsFacButton)
                    .addComponent(voidRayButton)
                    .addComponent(colossiButton)
                    .addComponent(highButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roboticsBayButton)
                    .addComponent(shrineButton)
                    .addComponent(templarButton)
                    .addComponent(darkButton)
                    .addComponent(carrierButton))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nexusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nexusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nexusButtonActionPerformed

    private void probeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_probeButtonActionPerformed

    private void pylonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pylonButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pylonButtonActionPerformed

    private void assimilatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assimilatorButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assimilatorButtonActionPerformed

    private void gatewayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gatewayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gatewayButtonActionPerformed

    private void cyberneticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cyberneticsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cyberneticsButtonActionPerformed

    private void roboticsFacButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roboticsFacButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roboticsFacButtonActionPerformed

    private void stargateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stargateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stargateButtonActionPerformed

    private void templarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_templarButtonActionPerformed

    private void twilightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twilightButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twilightButtonActionPerformed

    private void shrineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shrineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shrineButtonActionPerformed

    private void roboticsBayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roboticsBayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roboticsBayButtonActionPerformed

    private void zealotBurronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zealotBurronActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zealotBurronActionPerformed

    private void stalkerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stalkerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stalkerButtonActionPerformed

    private void sentryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sentryButtonActionPerformed

    private void observerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_observerButtonActionPerformed

    private void immortalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_immortalButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_immortalButtonActionPerformed

    private void phoenixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoenixButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoenixButtonActionPerformed

    private void voidRayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voidRayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_voidRayButtonActionPerformed

    private void colossiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colossiButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colossiButtonActionPerformed

    private void highButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highButtonActionPerformed

    private void darkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_darkButtonActionPerformed

    private void carrierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrierButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carrierButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUIForm().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void readMe() throws IOException {
        FileReader reader = new FileReader("startup.txt");
        gameStateArea.read(reader, "startup.txt");
        gameStateArea.repaint();
        gameStateArea.revalidate();
        //FileReader reader2 = new FileReader("selection.txt");
        //gameStateArea.read(reader2, "selection.txt");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerChoiceText;
    private javax.swing.JButton assimilatorButton;
    private javax.swing.JLabel buildingLabel;
    private javax.swing.JButton carrierButton;
    private javax.swing.JButton colossiButton;
    private javax.swing.JButton cyberneticsButton;
    private javax.swing.JButton darkButton;
    private javax.swing.JTextArea gameStateArea;
    private javax.swing.JLabel gasCount;
    private javax.swing.JLabel gasLabel;
    private javax.swing.JButton gatewayButton;
    private javax.swing.JButton highButton;
    private javax.swing.JButton immortalButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel materialContainer;
    private javax.swing.JLabel mineralCount;
    private javax.swing.JLabel mineralLabel;
    private javax.swing.JButton nexusButton;
    private javax.swing.JButton observerButton;
    private javax.swing.JButton phoenixButton;
    private javax.swing.JButton probeButton;
    private javax.swing.JButton pylonButton;
    private javax.swing.JButton roboticsBayButton;
    private javax.swing.JButton roboticsFacButton;
    private javax.swing.JButton sentryButton;
    private javax.swing.JButton shrineButton;
    private javax.swing.JButton stalkerButton;
    private javax.swing.JButton stargateButton;
    private javax.swing.JButton templarButton;
    private javax.swing.JLabel timeCount;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton twilightButton;
    private javax.swing.JLabel unitLabel;
    private javax.swing.JButton voidRayButton;
    private javax.swing.JButton zealotBurron;
    // End of variables declaration//GEN-END:variables

}