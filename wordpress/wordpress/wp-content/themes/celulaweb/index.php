
<?php get_header(); ?>

    <h1>Célula Web Tecnologia da informação</h1>

    <?php if(have_posts()){
      while (have_posts()) {
        the_post();

        ?>
        <div class="imagem-destaque-post">
          <?= the_post_thumbnail()  ?>
        </div>

        <h2><?php the_title(); ?></h2>
        <div><?php the_content(); ?></div><?php

      }
    } ?>

<?php get_footer(); ?>
