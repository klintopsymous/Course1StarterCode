package module6;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

import java.util.List;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	public static int ELI_SIZE = 5;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(0, 255, 0);
		pg.ellipse(x, y, ELI_SIZE, ELI_SIZE);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		String name = getCountry() + " " + getCity() + " ";
		String details = "Name: " + getName() + " Alt: " + getAlt() + " ";
		if (!getCode().replaceAll("\"", "").equals("")) {
			details = "Code: " + getCode() + " " + details;
		}
		name = name.replaceAll("\"", "");
		details = details.replaceAll("\"", "");

		pg.pushStyle();

		pg.fill(255, 255, 255);
		pg.textSize(12);
		pg.rectMode(PConstants.CORNER);
		pg.rect(x, y-ELI_SIZE-39, Math.max(pg.textWidth(name), pg.textWidth(details)) + 6, 39);
		pg.fill(0, 0, 0);
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.text(name, x+3, y-ELI_SIZE-33);
		pg.text(details, x+3, y - ELI_SIZE -18);

		pg.popStyle();
		// show routes
		
		
	}

	private String getCity() {
		return getStringProperty("city");
	}

	private String getCountry() {
		return getStringProperty("country");
	}

	private String getCode() {
		return getStringProperty("code");
	}

	private String getName() {
		return getStringProperty("name");
	}

	private String getAlt() {
		return getStringProperty("altitude");
	}
	
}
