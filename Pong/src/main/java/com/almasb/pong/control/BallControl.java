/*
 * The MIT License (MIT)
 *
 * FXGL - JavaFX Game Library
 *
 * Copyright (c) 2015-2016 AlmasB (almaslvl@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.almasb.pong.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.physics.PhysicsComponent;

/**
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class BallControl extends AbstractControl {

    private PhysicsComponent ball;

    @Override
    public void onAdded(Entity entity) {
        ball = entity.getComponentUnsafe(PhysicsComponent.class);
    }

    @Override
    public void onUpdate(Entity entity, double tpf) {
        limitVelocity();
    }

    private void limitVelocity() {
        if (Math.abs(ball.getLinearVelocity().getX()) < 5 * 60) {
            ball.setLinearVelocity(Math.signum(ball.getLinearVelocity().getX()) * 5 * 60,
                    ball.getLinearVelocity().getY());
        }

        if (Math.abs(ball.getLinearVelocity().getY()) > 5 * 60 * 2) {
            ball.setLinearVelocity(ball.getLinearVelocity().getX(),
                    Math.signum(ball.getLinearVelocity().getY()) * 5 * 60);
        }
    }
}
