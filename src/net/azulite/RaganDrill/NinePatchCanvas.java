package net.azulite.RaganDrill;

/**
 * GUI parts.
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class NinePatchCanvas extends Canvas implements ChangeListener
{
	private JSlider[] slider;
	private ImageFileChooser imgchooser;
	private DropImageFiles imgfiles;

	public NinePatchCanvas()
	{
		slider = new JSlider[ 4 ];

		// Up
		slider[ 0 ] = new JSlider();
		slider[ 0 ].addChangeListener( this );
		// Down
		slider[ 1 ] = new JSlider();
		slider[ 1 ].addChangeListener( this );
		slider[ 1 ].setInverted( true );
		// Left
		slider[ 2 ] = new JSlider( JSlider.VERTICAL );
		slider[ 2 ].addChangeListener( this );
		slider[ 2 ].setInverted( true );
		// Right
		slider[ 3 ] = new JSlider( JSlider.VERTICAL );
		slider[ 3 ].addChangeListener( this );

		imgfiles = new DropImageFiles();
	}

	public JSlider getSlider( int num )
	{
		return slider[ num ];
	}

	public JPanel getImageFileChooser( JFrame frame )
	{
		JTextField field = new JTextField();
		imgchooser = new ImageFileChooser( "Image file(PNG)", frame, field, imgfiles );
		JPanel buttonPanel = new JPanel();
		buttonPanel.add( imgchooser );
		
		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, imgchooser );
		
		return panel;
	}

	public void paint( Graphics g )
	{
		int sx, sy, ex, ey;
		//g.drawLine(10, 10, 120, 40);
		g.drawString( "" + slider[ 0 ].getValue() + "+" + slider[ 1 ].getValue() + "+" + slider[ 2 ].getValue() + "+" + slider[ 3 ].getValue(),
				0, 20 );

		sx = this.getWidth() * slider[ 0 ].getValue() / 100;
		ex = this.getWidth() * (100-slider[ 1 ].getValue()) / 100 - sx;
		g.drawRect( sx, 0, ex, 1 );
		g.drawRect( sx, this.getHeight() - 2, ex, 1 );

		sy = this.getHeight() * slider[ 2 ].getValue() / 100;
		ey = this.getHeight() * (100-slider[ 3 ].getValue()) / 100 - sy;
		g.drawRect( 0, sy, 1, ey );
		g.drawRect( this.getWidth() - 2, sy, 1, ey );
	}

	@Override
	public void stateChanged( ChangeEvent arg0 )
	{
		if ( arg0.getSource() == slider[ 0 ] )
		{
			// Up
			this.repaint();
		} else if ( arg0.getSource() == slider[ 1 ] )
		{
			// Down
			this.repaint();
		} else if ( arg0.getSource() == slider[ 2 ] )
		{
			// Left
			this.repaint();
		} else if ( arg0.getSource() == slider[ 3 ] )
		{
			// Right
			this.repaint();
		}
	}
}
