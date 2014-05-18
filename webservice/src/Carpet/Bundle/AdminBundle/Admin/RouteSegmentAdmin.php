<?php
// src/Acme/DemoBundle/Admin/PostAdmin.php

namespace Carpet\Bundle\AdminBundle\Admin;

use Sonata\AdminBundle\Admin\Admin;
use Sonata\AdminBundle\Datagrid\ListMapper;
use Sonata\AdminBundle\Datagrid\DatagridMapper;
use Sonata\AdminBundle\Form\FormMapper;

class RouteSegmentAdmin extends Admin
{
    // Fields to be shown on create/edit forms
    protected function configureFormFields(FormMapper $formMapper)
    {
        $formMapper
            ->add('start')
            ->add('end')
            ->add('start_lat')
            ->add('start_lon')
            ->add('end_lat')
            ->add('end_lon')
            ->add('distance')
            ->add('duration')
        ;
    }

    // Fields to be shown on filter forms
    protected function configureDatagridFilters(DatagridMapper $datagridMapper)
    {
        $datagridMapper
            ->add('start')
            ->add('end')
            ->add('distance')
            ->add('duration')
        ;
    }

    // Fields to be shown on lists
    protected function configureListFields(ListMapper $listMapper)
    {
        $listMapper
            ->addIdentifier('id')
            ->add('start')
            ->add('end')
            ->add('start_lat')
            ->add('start_lon')
            ->add('end_lat')
            ->add('end_lon')
            ->add('distance')
            ->add('duration')
        ;
    }
}