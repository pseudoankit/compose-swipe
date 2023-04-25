Compose utility to create a swipeable view

# Implementation
Go to Settings.gradle, inside repositories block ->

```
repositories {  
    maven { url 'https://jitpack.io' }
}
```

Module level build.gradle 

```
com.github.pseudoankit:SwipeableView:1.0.0
```

Implementation
```
SwipeableCard(
    config = SwipeableCardConfig(
        direction = direction,
        maxOffsetToReveal = 200f,
        revealThreshold = 50f
    ),
    modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    color = Color.Blue,
    shape = RoundedCornerShape(12.dp)
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Swipe card to reveal", color = Color.White)
    }
}
```


DEMO

https://user-images.githubusercontent.com/54987308/234168338-2290a219-a112-457d-8f6a-c52a83137e59.mov

