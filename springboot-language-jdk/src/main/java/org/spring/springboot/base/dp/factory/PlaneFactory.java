package org.spring.springboot.base.dp.factory;

public class PlaneFactory extends VehicleFactory {

	@Override
	Moveable create() {
		return new Plane();
	}
}
