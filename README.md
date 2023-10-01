# Railcraft Ctyrk4 Edition - A Minecraft Mod, Ctyrk4 Community server

## Waiting for CovertJaguar Permissions, this repo could go done any day. I dont take any credit for this mod whatsoever.
Original creator: [CovertJaguar](https://github.com/Railcraft) All credit goes to him!

## New in Ctyrk4 Edition

Added two new aspects used on CZ/SK railroads, these beeing Blue and White

## What is Railcraft?

Railcraft is a mod written for the hit game [Minecraft](https://minecraft.net/). It is built on top of the [Minecraft Forge](https://github.com/MinecraftForge) API.

It greatly expands and improves the Minecart system in Minecraft. Adding many new blocks, entities, and features. It has been in development since 2012 and contains over 800 class files and hundreds of thousands of lines of code.

The mod was created and is still currently maintained by the user going by the name **CovertJaguar**.

## Why are you posting the Source Code?

In the words of **CovertJaguar**:
> As a new modder, I originally feared losing control of my code, my brainchild. However, since that time, I have had the privelege of being Project Lead on two other major Minecraft Mod projects that provided access to the source: [Buildcraft](https://github.com/BuildCraft/BuildCraft) and [Forestry](https://github.com/ForestryMC/ForestryMC). I've generally found this to be a positive experiance resulting in many bug fixes and increased intermod compatibility.  While I still have some concerns, I have come to feel that the benefits of providing others access to my source code outweighs the negatives and unknowns. To that end, despite my missgivings, I made Source Access a [Patreon Milestone Goal](http://www.patreon.com/CovertJaguar). I had no idea whether I'd ever meet that Goal, but I decided to let the community decide, and decide they did, overwhelminging so! My Patrons are awesome. So, as promised, I am posting the Source Code.

## Official Links

* The Blog, Forums, and main download page: http://www.railcraft.info
* The Wiki: http://railcraft.info/wiki
* IRC: #railcraft on Esper.net - [WebChat](http://webchat.esper.net/?nick=RailcraftGithub...&channels=railcraft&prompt=1)
* Patreon Page: http://www.patreon.com/CovertJaguar

<a href="http://www.patreon.com/CovertJaguar"> ![Patreon](http://www.railcraft.info/wp-content/uploads/2014/05/Patreon.png)</a>

## Issues

Post only confirmed bugs [here](https://github.com/CovertJaguar/Railcraft/issues). Do not post crash logs, you can post pastebin links to FML logs, but no crash logs.

You must have read and performed the proper support procedure outlined [here](http://railcraft.info/wiki/info:support) before posting.

More information about issue Labels can be found [here](https://github.com/CovertJaguar/Railcraft/wiki/Issue-Labels).

## Building

The Railcraft Project follows standard Forge conventions for setting up and building a project, with a couple additional details (details to come).

You can create a gradle.properties file in the project root with the following properties:
```
mcUsername=Steve
mcPassword=ILoveNotch
```

Initial Setup from the Command Line:
```
gradlew setupDecompWorkspace eclipse
```

The [API](https://github.com/CovertJaguar/Railcraft-API) and [Localization](https://github.com/CovertJaguar/Railcraft-Localization) files reside in their own repositories and are pulled automatically into the main repo as git submodules. You will however need to run the following commands:
```
git submodule init
git submodule update
```

## License

Railcraft is licensed under a custom usage license tailored specifically for the project. It can be read [here](https://github.com/CovertJaguar/Railcraft/blob/master/LICENSE.md).

 * Key things to keep in mind:
  * You may **NOT** create works using the Railcraft code (source or binary) without CovertJaguar's explicit permission except in the cases listed in this license.
  * You may **NOT** create derivative Jars from Railcraft source to distribute to other users.
  * You **MAY** use snippets of Railcraft Code posted on the Official Github in your own projects, but only if your project consists of less than 25% of Railcraft derived code. You must give credit to the Railcraft Project for the code used, including a link to the Github Project. Put this in your class file headers that contain Railcraft code, in your readme, and on the main download page.
  * You may **NOT** use Railcraft Art Assets in other projects **unless** the project is intended to operate alongside Railcraft. Examples are Addons and InterMod Integration.
  * You **MAY** fork and edit the Github Project for the purpose of contributing to the Official Railcraft Project. You may **NOT** distribute any Jar created from a fork for any reason.
  * All contributions to the Official Railcraft Project must be covered by a Contributor Licensing Agreement signed by the contributor.
