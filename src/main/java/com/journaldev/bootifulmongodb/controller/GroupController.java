package com.journaldev.bootifulmongodb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.GroupRepository;
import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.Group;
import com.journaldev.bootifulmongodb.model.User;
//edited1
// edited34
Docs 
Framework 
Guide
Components
CLI
Native
Support
Community
v3 
GitHub 
Docs 
Action Sheet
ion-action-sheet-controller
ion-action-sheet
Alert
ion-alert-controller
ion-alert
Badge
ion-badge
Button
ion-button
ion-ripple-effect
Card
ion-card
ion-card-content
ion-card-header
ion-card-subtitle
ion-card-title
Checkbox
ion-checkbox
Chip
ion-chip
Content
ion-app
ion-content
Date & Time Pickers
ion-datetime
ion-picker-controller
ion-picker
Floating Action Button
ion-fab-button
ion-fab-list
ion-fab
Grid
ion-col
ion-row
ion-grid
Infinite Scroll
ion-infinite-scroll-content
ion-infinite-scroll
Icons
ion-icon
Input
ion-input
ion-textarea
Item
ion-item
ion-item-divider
ion-item-group
ion-item-sliding
ion-item-options
ion-item-option
ion-label
ion-note
List
ion-list
ion-list-header
ion-virtual-scroll
Media
ion-avatar
ion-icon
ion-img
ion-thumbnail
Menu
ion-menu-button
ion-menu-controller
ion-menu-toggle
ion-menu
ion-split-pane
Modal
ion-modal-controller
ion-modal
Navigation
ion-nav-pop
ion-nav-push
ion-nav-set-root
ion-nav
Popover
ion-popover-controller
ion-popover
Progress Indicators
ion-loading
ion-loading-controller
ion-progress-bar
ion-skeleton-text
ion-spinner
Radio
ion-radio-group
ion-radio
Range
ion-range
Refresher
ion-refresher-content
ion-refresher
Reorder
ion-reorder-group
ion-reorder
Routing
ion-route-redirect
ion-route
ion-router-outlet
ion-router
Searchbar
ion-searchbar
Segment
ion-segment-button
ion-segment
Select
ion-select-option
ion-select
Slides
ion-slide
ion-slides
Tabs
ion-tab-bar
ion-tab-button
ion-tab
ion-tabs
Toast
ion-toast-controller
ion-toast
Toggle
ion-toggle
Toolbar
ion-toolbar
ion-footer
ion-header
ion-title
ion-buttons
ion-back-button
Typography
ion-anchor
ion-text
Resources
API Index
ion-menu
CONTENTS
Usage
Properties
Events
Methods
CSS Custom Properties
The Menu component is a navigation drawer that slides in from the side of the current view. By default, it slides in from the left, but the side can be overridden. The menu will be displayed differently based on the mode, however the display type can be changed to any of the available menu types. The menu element should be a sibling to the root content element. There can be any number of menus attached to the content. These can be controlled from the templates, or programmatically using the MenuController.

Usage
ANGULARJAVASCRIPT
<ion-menu side="start" menuId="first">
  <ion-header>
    <ion-toolbar color="primary">
      <ion-title>Start Menu</ion-title>
    </ion-toolbar>
  </ion-header>
  <ion-content>
    <ion-list>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
    </ion-list>
  </ion-content>
</ion-menu>

<ion-menu side="start" menuId="custom" class="my-custom-menu">
  <ion-header>
    <ion-toolbar color="tertiary">
      <ion-title>Custom Menu</ion-title>
    </ion-toolbar>
  </ion-header>
  <ion-content>
    <ion-list>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
    </ion-list>
  </ion-content>
</ion-menu>

<ion-menu side="end" type="push">
  <ion-header>
    <ion-toolbar color="danger">
      <ion-title>End Menu</ion-title>
    </ion-toolbar>
  </ion-header>
  <ion-content>
    <ion-list>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
      <ion-item>Menu Item</ion-item>
    </ion-list>
  </ion-content>
</ion-menu>

<ion-router-outlet main></ion-router-outlet>
import { Component } from '@angular/core';
import { MenuController } from '@ionic/angular';

@Component({
  selector: 'menu-example',
  templateUrl: 'menu-example.html',
  styleUrls: ['./menu-example.css'],
})
export class MenuExample {

constructor(private menu: MenuController) { }

  openFirst() {
    this.menu.enable(true, 'first');
    this.menu.open('first');
  }

  openEnd() {
    this.menu.open('end');
  }

  openCustom() {
    this.menu.enable(true, 'custom');
    this.menu.open('custom');
  }
}
.my-custom-menu {
  --width: 500px;
}
Properties
contentId
Description	
The content's id the menu should use.

Attribute	content-id
Type	string | undefined
disabled
Description	
If true, the menu is disabled.

Attribute	disabled
Type	boolean
maxEdgeStart
Description	
The edge threshold for dragging the menu open. If a drag/swipe happens over this value, the menu is not triggered.

Attribute	max-edge-start
Type	number
menuId
Description	
An id for the menu.

Attribute	menu-id
Type	string | undefined
side
Description	
Which side of the view the menu should be placed.

Attribute	side
Type	"end" | "start"
swipeGesture
Description	
If true, swiping the menu is enabled.

Attribute	swipe-gesture
Type	boolean
type
Description	
The display type of the menu. Available options: "overlay", "reveal", "push".

Attribute	type
Type	string | undefined
Events
Name	Description
ionDidClose	Emitted when the menu is closed.
ionDidOpen	Emitted when the menu is open.
ionWillClose	Emitted when the menu is about to be closed.
ionWillOpen	Emitted when the menu is about to be opened.
Methods
close
Description	
Closes the menu. If the menu is already closed or it can't be closed, it returns false.

Signature	close(animated?: boolean) => Promise<boolean>
isActive
Description	
Returns true is the menu is active.

A menu is active when it can be opened or closed, meaning it's enabled and it's not part of a ion-split-pane.

Signature	isActive() => Promise<boolean>
isOpen
Description	
Returns true is the menu is open.

Signature	isOpen() => Promise<boolean>
open
Description	
Opens the menu. If the menu is already open or it can't be opened, it returns false.

Signature	open(animated?: boolean) => Promise<boolean>
setOpen
Description	
Opens or closes the button. If the operation can't be completed successfully, it returns false.

Signature	setOpen(shouldOpen: boolean, animated?: boolean) => Promise<boolean>
toggle
Description	
Toggles the menu. If the menu is already open, it will try to close, otherwise it will try to open it. If the operation can't be completed successfully, it returns false.

Signature	toggle(animated?: boolean) => Promise<boolean>
CSS Custom Properties
Name	Description
--background	Background of the menu
--height	Height of the menu
--max-height	Maximum height of the menu
--max-width	Maximum width of the menu
--min-height	Minimum height of the menu
--min-width	Minimum width of the menu
--width	Width of the menu
IOS
MD

@RestController
@RequestMapping(value="/rest")
public class GroupController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupRepository groupRepository;
	
	@RequestMapping(value = "/createGroup/{owner_id}/{member_id}", method = RequestMethod.POST)
	public Group createGroup(@PathVariable("owner_id")  int owner_id,@PathVariable("member_id") int member_id) {
		User owner = userRepository.findOne(owner_id);
		User member = userRepository.findOne(member_id);
		Group g = new Group();
		g.setOwner(owner);
		System.out.println(owner + " " + member);
		ArrayList<User> list = new ArrayList<User>();
		if(owner.getGroups()==null) {
			list.add(member);
			g.setMember(list);
//			owner.setGroups(g);
			groupRepository.save(g);
//			userRepository.save(owner);
			
			
		}
		else {
			ArrayList<User> list2 = new ArrayList<>();
			list2 = owner.getGroups().getMember();
			list2.add(member);
			g.setMember(list2);
//			owner.setGroups(g);
			groupRepository.save(g);
//			userRepository.save(owner);
			
		}
		return g;
		
	}
	
}
