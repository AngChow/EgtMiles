/**
 * 
 */
package com.ckt.vas.miles.ui.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ckt.vas.miles.R;
import com.ckt.vas.miles.dto.ActivityMessage;
import com.ckt.vas.miles.ui.adapters.PublicActivityAdapter;
import com.ckt.vas.miles.ui.views.MenuRightAnimations;

/**
 * @author Gauss
 * 
 */
public class MainViewActivity extends Activity {
	/** Called when the activity is first created. */
	private boolean areButtonsShowing;
	private RelativeLayout composerButtonsWrapper;
	private ImageView composerButtonsShowHideButtonIcon;
	private RelativeLayout composerButtonsShowHideButton;

	private RelativeLayout overlayView;
	private ListView chatHistoryLv;

	// activity_overlay
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);
		initMainView(this);
	}
	
	private void initMainView(Context context){
		//View mainView = View.inflate(context,R.layout.feed_activity2,null);

		MenuRightAnimations.initOffset(MainViewActivity.this);
		composerButtonsWrapper = (RelativeLayout) findViewById(R.id.composer_buttons_wrapper);
		composerButtonsShowHideButton = (RelativeLayout)findViewById(R.id.composer_buttons_show_hide_button);
		composerButtonsShowHideButtonIcon = (ImageView) findViewById(R.id.composer_buttons_show_hide_button_icon);

		composerButtonsShowHideButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("onclick....................");
				if (!areButtonsShowing) {
					MenuRightAnimations.startAnimationsIn(composerButtonsWrapper, 300);
					composerButtonsShowHideButtonIcon.startAnimation(MenuRightAnimations.getRotateAnimation(0, -315,
							300));
				} else {
					MenuRightAnimations.startAnimationsOut(composerButtonsWrapper, 300);
					composerButtonsShowHideButtonIcon.startAnimation(MenuRightAnimations.getRotateAnimation(-315, 0,
							300));
				}
				areButtonsShowing = !areButtonsShowing;
			}
		});
		for (int i = 0; i < composerButtonsWrapper.getChildCount(); i++) {
			composerButtonsWrapper.getChildAt(i).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
				}
			});
		}

		composerButtonsShowHideButton.startAnimation(MenuRightAnimations.getRotateAnimation(0, 360, 200));

		//chatHistoryLv = (ListView)findViewById(R.id.list_view);
		//setAdapterForThis();
		// splash.setVisibility(View.GONE);

		//return mainView;
	}

	private List<ActivityMessage> messages = new ArrayList<ActivityMessage>();

	private void initMessages() {
		// set header
		messages.add(new ActivityMessage());

		// data
				// text
				messages.add(new ActivityMessage(R.drawable.gauss0, "Gauss", "龙抄手(春熙路店)", "真不错",1333153510605l));

				// img
				messages.add(new ActivityMessage(R.drawable.andrew0, "Andrew", "库仑咖啡", "真不错", R.drawable.coffe1,1333163510605l));

				// friend
				messages.add(new ActivityMessage(R.drawable.andrew0, "Andrew", "Gauss", R.drawable.gauss1,1333173510605l));

				// img
				messages.add(new ActivityMessage(R.drawable.andrew0, "Andrew", "特美西餐厅(春熙路店)", "真不错", R.drawable.coffe2,1333183510605l));
				messages.add(new ActivityMessage(R.drawable.gauss0, "Gauss", "甲山册林Coffe(武侯路店)", "真不错", R.drawable.coffe3,1333193510605l));

				// friend
				messages.add(new ActivityMessage(R.drawable.gauss0, "Gauss", "Andrew", R.drawable.andrew1,1333166510605l));
				messages.add(new ActivityMessage(R.drawable.andrew0, "Andrew", "Gauss", R.drawable.gauss1,1333170510605l));

				// img
				messages.add(new ActivityMessage(R.drawable.andrew0, "Andrew", "枫林晚纯真咖啡馆", "真不错", R.drawable.coffe0,1333171510605l));
				messages.add(new ActivityMessage(R.drawable.gauss0, "Gauss", "龙抄手(武侯路店)", "真不错", R.drawable.coffe5,1333176510605l));

				// img
				messages.add(new ActivityMessage(R.drawable.andrew0, "Andrew", "麦当劳(春熙路店)", "真不错", R.drawable.coffe1,1333185510605l));
				messages.add(new ActivityMessage(R.drawable.gauss0, "Gauss", "龙抄手(武侯路店)", "真不错", R.drawable.coffe2,1333187510605l));
	}

	PublicActivityAdapter chatHistoryAdapter;

	private void setAdapterForThis() {
		initMessages();
		chatHistoryAdapter = new PublicActivityAdapter(this, messages);
		chatHistoryLv.setAdapter(chatHistoryAdapter);
	}

}
