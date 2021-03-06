package com.almasb.slotmachine.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.component.MainViewComponent;
import com.almasb.slotmachine.EntityType;
import com.almasb.slotmachine.SlotMachineApp;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class LeverControl extends AbstractControl {

    private MainViewComponent view;
    private String currentTexture = "lever0.png";

    @Override
    public void onAdded(Entity entity) {
        view = Entities.getMainView(entity);

        view.getView().setOnMouseClicked(e -> {
            trigger();
        });
    }

    @Override
    public void onUpdate(Entity entity, double tpf) {

    }

    public void trigger() {
        if (FXGL.<SlotMachineApp>getAppCast().isMachineSpinning())
            return;

        currentTexture = currentTexture.equals("lever0.png") ? "lever1.png" : "lever0.png";

        view.setTexture(currentTexture);

        FXGL.<SlotMachineApp>getAppCast().spin();
    }
}
